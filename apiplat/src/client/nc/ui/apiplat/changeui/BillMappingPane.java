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
 * �ӿ�ƽ̨����ת��UI-��Ƭ�༭���� <br/>
 * shidl@yonyou.com<br/>
 * 2018/04/12<br/>
 */
public class BillMappingPane extends UIPanel {

	private UITabbedPane tabPane;

	// ��ǰ�Ľ�����ϢVO
	private ExchangeVO currExchangeVO = null;

	private UITablePane vochangebTablePane;

	private ExchangebTableModel vochangebTableModel;

	public BillMappingPane() {
		super();

		initUI();

		initTableStyle();
	}

	/**
	 * ��ʼ���༭���
	 */
	private void initTableStyle() {
		// ���������ֶ�
		getVochangebTablePane()
				.getTable()
				.getColumnModel()
				.getColumn(3)
				.setCellEditor(
						new DefaultCellEditor(getVochangebTableModel()
								.getCombTransLogicStyle()));
		// ��������ֶ�
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
			tabPane.add("�ӿ�ƽ̨������ת������", getVochangebTablePane());
		}
		return tabPane;
	}

	public void initBillMapping(ExchangeVO exchangeVO) throws BusinessException, IllegalAccessException, InvocationTargetException {
		this.currExchangeVO = exchangeVO;
		long s = System.currentTimeMillis();
		Logger.debug("��ʼ���ӿ�ƽ̨������ת��������忪ʼ");
		setBorder(BorderFactory.createTitledBorder(null, "�ӿ�ƽ̨����ת������",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		// ��վ�������
		getVochangebTableModel().clearTable();

		getVochangebTableModel().setCurExchangeVO(currExchangeVO);

		// ����ӱ�ת����������
		fillMapping();

		long e = System.currentTimeMillis();
		Logger.debug("��ʼ���ӿ�ƽ̨������ת����������ʱ" + (e - s) + "ms");
	}

	/**
	 * ����ӱ�ת����������
	 * 
	 * @throws BusinessException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void fillMapping() throws BusinessException,
			IllegalAccessException, InvocationTargetException {

		// 1.����״̬���-ת������
		// ��Ԫ���ݵõ�Ŀ�ĵ��ݵ���������
		Collection<ExchangeRuleVO> coRuleVOs = new ArrayList<ExchangeRuleVO>();
		IBusinessEntity destBE = nc.util.apiplat.TreeUtil.MDUtil
				.queryMetaOfMDCode(this.currExchangeVO.getNc_bill_type());
		List<IAttribute> alAttr = destBE.getAttributes();
		HashMap<String, String[]> code2refInfo = new HashMap<String, String[]>();
		for (IAttribute attr : alAttr) {
			IType t = attr.getDataType();
			ExchangeRuleVO r = new ExchangeRuleVO();
			if (MDUtil.isMDBean(t) || MDUtil.isCollectionType(t)) {
				// �õ�ĳ���Ե�����ʵ�壬������������
				IBusinessEntity refBE = PfMetadataTools
						.getBusinessEntityOfAttr(attr);
				List<IAttribute> alAttrOfRefBE = refBE.getAttributes();
				for (IAttribute attrOfRefBE : alAttrOfRefBE) {
					r.setNc_field_code(attr.getName() + "."
							+ attrOfRefBE.getName());
					r.setNc_field_name(attr.getDisplayName() + "."
							+ attrOfRefBE.getDisplayName());
					// ȡ��ͷĬ�Ϸ������
					r.setTrans_rule(currExchangeVO.getDefault_trans_rule());
				}
			} else {
				r.setNc_field_code(attr.getName());
				r.setNc_field_name(attr.getDisplayName());
				// ȡ��ͷĬ�Ϸ������
				r.setTrans_rule(currExchangeVO.getDefault_trans_rule());
			}
			// �ж��Ƿ��ǲ���
			if (MDUtil.isRefType(t)) {
				IBusinessEntity refBusiEntity = (IBusinessEntity) ((RefType) t)
						.getRefType();
				String classID = refBusiEntity.getID();
				// ��ѯ���������Ϣ
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

		// �����ݿ��ж�ȡ��������
		ExchangeVO existedVO = NCLocator.getInstance().lookup(IExchange.class)
				.loadExistExchangeVOWithDetail(currExchangeVO);
		if (existedVO == null) {
			//
			MessageDialog.showHintDlg(this, "��ʾ", "��ǰת�������Ҳ�������δ����");
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
					// ȡ��ͷĬ�Ϸ�����򣬷�ֹ���ݿ�ȡֵ����
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
		// �����������
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
		// У����Ч��
		checkValid();

		// ��������
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
	 * FIXME:��Щ�߼�ͬ�� PfUtilBaseTools.initDestBillVO()����
	 * 
	 * @throws BusinessException
	 */
	private void checkValid() throws BusinessException {

	}

}
