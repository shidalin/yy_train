package nc.ui.apiplat.changeui;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import org.apache.commons.beanutils.BeanUtils;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.md.model.IAttribute;
import nc.md.model.IBusinessEntity;
import nc.md.model.type.IType;
import nc.md.model.type.impl.RefType;
import nc.md.util.MDUtil;
import nc.uap.pf.metadata.PfMetadataTools;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIPanel;
import nc.ui.pub.beans.UITabbedPane;
import nc.ui.pub.beans.UITablePane;
import nc.util.apiplat.itf.IExchange;
import nc.vo.apiplat.exchange.ExchangeRuleVO;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.pub.BusinessException;

/**
 * 接口平台数据转换UI-卡片编辑界面 <br/>
 * shidl@yonyou.com<br/>
 * 2018/04/12<br/>
 */
public class BillMappingPane extends UIPanel {

	private UITabbedPane tabPane;

	// 当前的交换信息VO
	private ExchangeVO currExchangeVO = null;

	private UITablePane vochangebTablePane;

	private ExchangebTableModel vochangebTableModel;

	public BillMappingPane() {
		super();

		initUI();

		initTableStyle();
	}

	/**
	 * 初始化编辑面板
	 */
	private void initTableStyle() {
		// 交换类型字段
		getVochangebTablePane()
				.getTable()
				.getColumnModel()
				.getColumn(3)
				.setCellEditor(
						new DefaultCellEditor(getVochangebTableModel()
								.getCombTransLogicStyle()));
		// 翻译规则字段
		getVochangebTablePane()
				.getTable()
				.getColumnModel()
				.getColumn(4)
				.setCellEditor(
						new DefaultCellEditor(getVochangebTableModel()
								.getCombTransRule()));
	}

	private void initUI() {
		setLayout(new BorderLayout());
		add(getTabPane(), BorderLayout.CENTER);
	}

	public UITabbedPane getTabPane() {
		if (tabPane == null) {
			tabPane = new UITabbedPane();
			tabPane.add("接口平台·数据转换规则", getVochangebTablePane());
		}
		return tabPane;
	}

	public void initBillMapping(ExchangeVO exchangeVO) throws BusinessException, IllegalAccessException, InvocationTargetException {
		this.currExchangeVO = exchangeVO;
		long s = System.currentTimeMillis();
		Logger.debug("初始化接口平台·数据转换规则面板开始");
		setBorder(BorderFactory.createTitledBorder(null, "接口平台数据转换规则",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		// 清空旧有数据
		getVochangebTableModel().clearTable();

		getVochangebTableModel().setCurExchangeVO(currExchangeVO);

		// 填充子表转换规则数据
		fillMapping();

		long e = System.currentTimeMillis();
		Logger.debug("初始化接口平台·数据转换规则面板耗时" + (e - s) + "ms");
	}

	/**
	 * 填充子表转换规则数据
	 * 
	 * @throws BusinessException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void fillMapping() throws BusinessException,
			IllegalAccessException, InvocationTargetException {

		// 1.新增状态填充-转换规则
		// 从元数据得到目的单据的所有属性
		Collection<ExchangeRuleVO> coRuleVOs = new ArrayList<ExchangeRuleVO>();
		IBusinessEntity destBE = nc.util.apiplat.TreeUtil.MDUtil
				.queryMetaOfMDCode(this.currExchangeVO.getNc_bill_type());
		List<IAttribute> alAttr = destBE.getAttributes();
		HashMap<String, String[]> code2refInfo = new HashMap<String, String[]>();
		for (IAttribute attr : alAttr) {
			IType t = attr.getDataType();
			ExchangeRuleVO r = new ExchangeRuleVO();
			if (MDUtil.isMDBean(t) || MDUtil.isCollectionType(t)) {
				// 得到某属性的引用实体，并遍历其属性
				IBusinessEntity refBE = PfMetadataTools
						.getBusinessEntityOfAttr(attr);
				List<IAttribute> alAttrOfRefBE = refBE.getAttributes();
				for (IAttribute attrOfRefBE : alAttrOfRefBE) {
					r.setNc_field_code(attr.getName() + "."
							+ attrOfRefBE.getName());
					r.setNc_field_name(attr.getDisplayName() + "."
							+ attrOfRefBE.getDisplayName());
					// 取表头默认翻译规则
					r.setTrans_rule(currExchangeVO.getDefault_trans_rule());
				}
			} else {
				r.setNc_field_code(attr.getName());
				r.setNc_field_name(attr.getDisplayName());
				// 取表头默认翻译规则
				r.setTrans_rule(currExchangeVO.getDefault_trans_rule());
			}
			// 判断是否是参照
			if (MDUtil.isRefType(t)) {
				IBusinessEntity refBusiEntity = (IBusinessEntity) ((RefType) t)
						.getRefType();
				String classID = refBusiEntity.getID();
				// 查询参照相关信息
				HashMap<String, String> refMap = nc.util.apiplat.TreeUtil.MDUtil
						.queryRefMapByClassID(classID);
				if (refMap != null && refMap.keySet().size() > 0) {
					r.setCode_refinfo(refMap.get("code"));
					r.setName_refinfo(refMap.get("name"));
					code2refInfo.put(
							r.getNc_field_code(),
							new String[] { r.getCode_refinfo(),
									r.getName_refinfo() });
				}
			}
			coRuleVOs.add(r);
		}

		// 从数据库中读取交换规则
		ExchangeVO existedVO = NCLocator.getInstance().lookup(IExchange.class)
				.loadExistExchangeVOWithDetail(currExchangeVO);
		if (existedVO == null) {
			//
			MessageDialog.showHintDlg(this, "提示", "当前转换规则找不到或尚未配置");
		}

		ArrayList<ExchangeRuleVO> existedRules = existedVO == null ? null
				: existedVO.getRuleVOList();
		if (existedRules != null && existedRules.size() > 0) {
			HashMap<String, ExchangeRuleVO> code2vo = new HashMap<String, ExchangeRuleVO>();
			for (ExchangeRuleVO existedRule : existedRules) {
				code2vo.put(existedRule.getNc_field_code(), existedRule);
			}
			for (ExchangeRuleVO coRuleVO : coRuleVOs) {
				ExchangeRuleVO existedExchangeRuleVO = code2vo.get(coRuleVO
						.getNc_field_code());
				if (existedExchangeRuleVO != null) {
					BeanUtils.copyProperties(coRuleVO, existedExchangeRuleVO);
					// 取表头默认翻译规则，防止数据库取值覆盖
					coRuleVO.setTrans_rule(currExchangeVO
							.getDefault_trans_rule());
					if (code2refInfo.get(coRuleVO.getNc_field_code()) != null) {
						coRuleVO.setCode_refinfo(code2refInfo.get(coRuleVO
								.getNc_field_code())[0]);
						coRuleVO.setName_refinfo(code2refInfo.get(coRuleVO
								.getNc_field_code())[1]);
					}
				}
			}
			// coRuleVOs = existedRules;
		}

		// }
		// 界面加载数据
		getVochangebTableModel()
				.addVO(coRuleVOs.toArray(new ExchangeRuleVO[0]));

	}

	private UITablePane getVochangebTablePane() {
		if (vochangebTablePane == null) {
			vochangebTablePane = new UITablePane();

			vochangebTablePane.getTable().addSortListener();
			vochangebTablePane.getTable().setAutoResizeMode(
					JTable.AUTO_RESIZE_OFF);
			vochangebTablePane.getTable().setModel(getVochangebTableModel());
			vochangebTablePane.getTable().setColumnWidth(
					getVochangebTableModel().getColWidths());
			vochangebTablePane.getTable().setSelectionMode(
					ListSelectionModel.SINGLE_SELECTION);
		}
		return vochangebTablePane;
	}

	private ExchangebTableModel getVochangebTableModel() {
		if (vochangebTableModel == null) {
			vochangebTableModel = new ExchangebTableModel(ExchangeRuleVO.class);
			vochangebTableModel.setContainTable(getVochangebTablePane()
					.getTable());
		}
		return vochangebTableModel;
	}

	public void stopEditing() {
		if (getVochangebTablePane().getTable().getCellEditor() != null) {
			getVochangebTablePane().getTable().getCellEditor()
					.stopCellEditing();
		}
	}

	public void cancelEditing() {
		if (getVochangebTablePane().getTable().getCellEditor() != null) {
			getVochangebTablePane().getTable().getCellEditor()
					.cancelCellEditing();
		}
	}

	public void saveMapping() throws BusinessException {
		// 校验有效性
		checkValid();

		// 交换规则
		Vector<ExchangeRuleVO> vecRuleVO = getVochangebTableModel().getVOs();
		currExchangeVO.getRuleVOList().clear();
		for (ExchangeRuleVO exvo : vecRuleVO) {
			currExchangeVO.getRuleVOList().add(exvo);
		}
		String pk = NCLocator.getInstance().lookup(IExchange.class)
				.saveBillMapping(currExchangeVO);
		currExchangeVO.setPrimaryKey(pk);

	}

	/**
	 * FIXME:有些逻辑同于 PfUtilBaseTools.initDestBillVO()方法
	 * 
	 * @throws BusinessException
	 */
	private void checkValid() throws BusinessException {

	}

}
