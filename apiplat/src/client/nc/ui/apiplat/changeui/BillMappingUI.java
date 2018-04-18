package nc.ui.apiplat.changeui;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.uif2.VersionConflictException;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.uap.IUAPQueryBS;
import nc.ui.bd.manage.UIRefCellEditor;
import nc.ui.ml.NCLangRes;
import nc.ui.pf.changeui.UIStatusEnum;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.SeparatorButtonObject;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITablePane;
import nc.ui.pub.desktop.PFToftPanel;
import nc.ui.pub.hotkey.HotkeyFactory;
import nc.ui.pub.hotkey.IHotkeyTypes;
import nc.ui.querytemplate.QueryConditionDLG;
import nc.ui.uif2.ExceptionHandlerWithDLG;
import nc.ui.uif2.IExceptionHandler;
import nc.util.apiplat.TreeUtil.PubExchangeUtil;
import nc.util.apiplat.itf.IExchange;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pu.m21.entity.OrderHeaderVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.hotkey.NCKey;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.querytemplate.TemplateInfo;
import nc.vo.uap.pf.PFBusinessException;

import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;

/**
 * 接口平台数据转换UI-列表界面 <br/>
 * shidl@yonyou.com<br/>
 * 2018/04/10<br/>
 * 
 * 
 * 分配职责涉及的数据库表： <br/>
 * 职责：sm_responsibility <br/>
 * 职责_功能：sm_resp_func
 */
public class BillMappingUI extends PFToftPanel implements ListSelectionListener {

	// 当前UI的编辑状态，初始为浏览态
	private UIStatusEnum m_uiStatus = UIStatusEnum.NOT_EDIT;

	private ButtonObject m_boQuery = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "PfExptlogUI-000002")/* 查询 */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000000")/* 查询单据VO交换规则 */, 2, "Query"/* 查询 */);

	private ButtonObject m_boNew = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "BillMappingUI-000001")/* 新增 */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000002")/* 新增单据VO交换规则 */, 2, "New"/* 新增 */);

	private ButtonObject m_boDelete = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "DeleteLabel")/* 删除 */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000003")/* 删除单据VO交换规则 */, 2, "Delete"/* 删除 */);

	private ButtonObject m_boEdit = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "EditCellLabel")/* 编辑 */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "EditCellLabel")/* 编辑 */,
			2, "Edit"/* 编辑 */);

	private ButtonObject m_boBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000004")/* 设置规则 */, NCLangRes.getInstance()
					.getStrByID("pfworkflow", "BillMappingUI-000004")/* 设置规则 */,
			2, "BillMapping"/* 设置规则 */);

	private ButtonObject m_boRefresh = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "UfWorkflowDesignerUI-000000")/* 刷新 */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"UfWorkflowDesignerUI-000000")/* 刷新 */, 2, "Refresh"/* 刷新 */);

	private ButtonObject m_boTest = new ButtonObject("测试", "测试", 2, "Test");

	private ButtonObject m_boSave = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "saveBtnName")/* 保存 */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "saveBtnName")/* 保存 */, 2,
			"Save"/* 保存 */);

	private ButtonObject m_boCancel = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "cancelBtnName")/* 取消 */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "cancelBtnName")/* 取消 */,
			2, "Cancel"/* 取消 */);

	private SeparatorButtonObject m_boSeparator = new SeparatorButtonObject();

	// 主界面菜单按钮
	private ButtonObject[] m_boGroup = { m_boNew, m_boEdit, m_boDelete,
			m_boSeparator, m_boQuery, m_boRefresh, m_boSeparator,
			m_boBillMapping, m_boTest };

	private ButtonObject[] m_boEditGroup = { m_boSave, m_boCancel };

	private ButtonObject m_boCancelBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000005")/* 取消设置规则 */, NCLangRes
					.getInstance().getStrByID("pfworkflow",
							"BillMappingUI-000005")/* 取消设置规则 */, 2,
			"CancelBillMapping"/* 取消设置规则 */);

	private ButtonObject m_boSaveBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000006")/* 保存交换规则 */, NCLangRes
					.getInstance().getStrByID("pfworkflow",
							"BillMappingUI-000006")/* 保存交换规则 */, 2,
			"SaveBillMapping"/* 保存交换规则 */);

	// 交换规则界面菜单按钮
	private ButtonObject[] m_boGroupMapping = { m_boSaveBillMapping,
			m_boCancelBillMapping };

	private UITablePane exchangeTablePane;

	private ExchangeTableModel exchangeTableModel;

	private IUAPQueryBS uapQryService = null;

	// 查询条件对话框
	private QueryConditionDLG qcd = null;

	// 单据转换规则查询模板
	private TemplateInfo tempinfo = null;

	// 当前查询条件
	private String sqlWhere = null;

	// 当前编辑行
	private int m_rowNumber = 0;

	private BillMappingPane m_billMappingPane;

	// 当前打开节点是否在开发平台下，若不在开发平台下，则默认就是集团级的，界面上不显示“集团级”属性选择框
	private UFBoolean isglobal;

	public BillMappingUI() {
		super();
	}

	public void init() {
		// 设置按钮
		setHotkeys();
		setButtons(m_boGroup);
		setName("BillMappingUI");

		String strParam = getParameter("isglobal");
		isglobal = UFBoolean.valueOf(strParam);
		add(getExchangeTablePane(), BorderLayout.CENTER);

		initTableStyle();

		initListeners();

		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();

		// 默认情况下刷新按钮不可用
		m_boRefresh.setEnabled(false);
		// 测试按钮
		m_boTest.setEnabled(true);

	}

	private void setHotkeys() {
		HotkeyFactory.fillBtnObjWithKotkey(m_boQuery, IHotkeyTypes.QUERY);
		HotkeyFactory.fillBtnObjWithKotkey(m_boNew, IHotkeyTypes.NEW);
		HotkeyFactory.fillBtnObjWithKotkey(m_boEdit, IHotkeyTypes.EDIT);
		HotkeyFactory.fillBtnObjWithKotkey(m_boSave, IHotkeyTypes.SAVE);
		HotkeyFactory.fillBtnObjWithKotkey(m_boCancel, IHotkeyTypes.CANCEL);
		HotkeyFactory.fillBtnObjWithKotkey(m_boDelete, IHotkeyTypes.DELETE);
		HotkeyFactory.fillBtnObjWithKotkey(m_boRefresh, IHotkeyTypes.REFRESH);

		HotkeyFactory.fillCustomHotkey(m_boBillMapping, NCKey.MODIFIERS_CTRL
				+ NCKey.MODIFIERS_ALT, "M", "(Ctrl+Alt+M)");
		HotkeyFactory
				.fillCustomHotkey(m_boCancelBillMapping, NCKey.MODIFIERS_CTRL
						+ NCKey.MODIFIERS_ALT, "Q", "(Ctrl+Alt+Q)");
		HotkeyFactory
				.fillCustomHotkey(m_boSaveBillMapping, NCKey.MODIFIERS_CTRL
						+ NCKey.MODIFIERS_ALT, "S", "(Ctrl+Alt+S)");
	}

	private void initListeners() {
		getExchangeTable().getSelectionModel().addListSelectionListener(this);
		if (getExchangeTable().getRowCount() > 0) {
			getExchangeTable().setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * 初始化编辑面板
	 */
	private void initTableStyle() {
		// 默认翻译规则字段
		getExchangeTable()
				.getColumnModel()
				.getColumn(4)
				.setCellEditor(
						new DefaultCellEditor(getExchangeTableModel()
								.getCombDefaultTransRule()));
		// 数据交换各式字段
		getExchangeTable()
				.getColumnModel()
				.getColumn(5)
				.setCellEditor(
						new DefaultCellEditor(getExchangeTableModel()
								.getCombTransStyle()));
		// NC系统单据类型字段
		getExchangeTable()
				.getColumnModel()
				.getColumn(6)
				.setCellEditor(
						new UIRefCellEditor(getExchangeTableModel()
								.getNCBillTypeRef()));
	}

	private void initData() {

		getExchangeTableModel().clearTable();

		// sqlWhere系查询对话框生成的sql condition语句
		// 若查询对话框中未设置任何条件，则此处sqlWhere将为null
		String sql = sqlWhere;
		try {
			Collection<ExchangeVO> coRet = getUAPQry().retrieveByClause(
					ExchangeVO.class, sql);

			if (coRet != null && coRet.size() > 0) {
				ExchangeVO[] exchangeVOs = coRet.toArray(new ExchangeVO[0]);

				getExchangeTableModel().addVO(exchangeVOs);
			}
		} catch (BusinessException e) {
			Logger.error(e.getMessage(), e);
			showErrorMessage("查询接口平台数据转换规则失败");
		}

		// 设置浏览态的UI
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
	}

	private ExchangeTableModel getExchangeTableModel() {
		if (exchangeTableModel == null) {
			exchangeTableModel = new ExchangeTableModel(ExchangeVO.class);
		}
		return exchangeTableModel;
	}

	private UITablePane getExchangeTablePane() {
		if (exchangeTablePane == null) {
			exchangeTablePane = new UITablePane();
			exchangeTablePane.setName("exchangeTablePane");
			exchangeTablePane.getTable().addSortListener();
			exchangeTablePane.getTable().setAutoResizeMode(
					JTable.AUTO_RESIZE_OFF);
			exchangeTablePane.getTable().setModel(getExchangeTableModel());
			// 当前选中行才能编辑
			getExchangeTableModel().setTable(exchangeTablePane.getTable());
			exchangeTablePane.getTable().setColumnWidth(
					getExchangeTableModel().getColWidths());
			exchangeTablePane.getTable().setSelectionMode(
					ListSelectionModel.SINGLE_SELECTION);
		}
		return exchangeTablePane;
	}

	private QueryConditionDLG getQueryConditionDLG() {
		if (qcd == null) {
			qcd = new QueryConditionDLG(this, getTemplateInfo());
		}

		return qcd;
	}

	/**
	 * 加载查询模版信息
	 * 
	 * @return
	 */
	private TemplateInfo getTemplateInfo() {
		if (tempinfo == null) {
			tempinfo = new TemplateInfo();
			if (WorkbenchEnvironment.getInstance().getGroupVO() == null
					|| StringUtils.isEmpty(WorkbenchEnvironment.getInstance()
							.getGroupVO().getPk_group())) {
				tempinfo.setPk_Org("@@@@");
			} else {
				tempinfo.setPk_Org(WorkbenchEnvironment.getInstance()
						.getGroupVO().getPk_group());
			}
			tempinfo.setFunNode("TR010501");
			tempinfo.setUserid(WorkbenchEnvironment.getInstance()
					.getLoginUser().getCuserid());
			tempinfo.setTemplateId("1001ZZ10000000008CXG");
		}

		return tempinfo;
	}

	private UITable getExchangeTable() {
		return getExchangeTablePane().getTable();
	}

	@Override
	public String getTitle() {
		return NCLangRes.getInstance().getStrByID("pfworkflow",
				"UPPpfworkflow-000586")/* 单据交换管理 */;
	}

	@Override
	public void onButtonClicked(ButtonObject bo) {
		if (bo == m_boQuery) {
			doQuery();
		} else if (bo == m_boNew) {
			doNew();
		} else if (bo == m_boEdit) {
			doEdit();
		} else if (bo == m_boDelete) {
			doDelete();
		} else if (bo == m_boSave) {
			doSave();
		} else if (bo == m_boCancel) {
			doCancel();
		} else if (bo == m_boRefresh) {
			doRefresh();
		} else if (bo == m_boTest) {
			doTest();
		} else if (bo == m_boBillMapping) {
			doEditMapping();
		}

		// m_boSaveBillMapping, m_boCancelBillMapping
		if (bo == m_boCancelBillMapping) {
			doCancelBillMapping();
		} else if (bo == m_boSaveBillMapping) {
			doSaveBillMapping();
		}
	}

	private void doQuery() {
		if (getQueryConditionDLG().showModal() == UIDialog.ID_OK) {
			getExchangeTableModel().clearTable();
			sqlWhere = getQueryConditionDLG().getWhereSQL();
			if (StringUtils.isBlank(sqlWhere)) {
				sqlWhere = "1=1";
			}
			initData();
			// 查询后刷新按钮可用
			m_boRefresh.setEnabled(true);
		}
	}

	private boolean doSaveBillMapping() {
		getBillMappingPane().stopEditing();
		try {
			getBillMappingPane().saveMapping();
		} catch (BusinessException e) {
			Logger.error(e.getMessage(), e);
			showErrorMessage(e.getMessage());
			return false;
		}

		// XXX:一旦保存，即回到主界面
		doCancelBillMapping();

		return true;
	}

	private void doCancelBillMapping() {
		// 切换UI
		getBillMappingPane().cancelEditing();

		remove(getBillMappingPane());
		add(getExchangeTablePane());
		// 设置按钮
		setButtons(m_boGroup);
		//
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
		repaint();
	}

	private void doCancel() {
		// 停止编辑
		if (getExchangeTable().getCellEditor() != null) {
			getExchangeTable().getCellEditor().stopCellEditing();
		}

		// 若为添加，则删除新添加的行
		if (m_uiStatus == UIStatusEnum.ADD) {
			getExchangeTableModel().removeVO(m_rowNumber);
		} else if (m_uiStatus == UIStatusEnum.EDIT) { // 若为修改，无动作
		}

		// 更新UI状态
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
	}

	private BillMappingPane getBillMappingPane() {
		if (m_billMappingPane == null) {
			m_billMappingPane = new BillMappingPane();
			m_billMappingPane.setName("BillMappingPane");
		}
		return m_billMappingPane;
	}

	private void doEditMapping() {
		int iSelectRow = getExchangeTable().getSelectedRow();
		if (iSelectRow < 0) {
			showErrorMessage(NCLangRes.getInstance().getStrByID("101202",
					"UPP101202-000003")/* 必须选择一行 */);
			return;
		}

		ExchangeVO exchangeVO = (ExchangeVO) getExchangeTableModel().getVO(
				iSelectRow);
		try {
			getBillMappingPane().initBillMapping(exchangeVO);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			showErrorMessage(NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000009", null,
					new String[] { e.getMessage() })/* 初始化单据交换界面出现异常：{0} */);
			return;
		}
		// 切换到设计面板
		this.remove(getExchangeTablePane());
		this.add(getBillMappingPane(), SwingConstants.CENTER);
		// 设置按钮
		setButtons(m_boGroupMapping);
		m_uiStatus = UIStatusEnum.EDIT_RULE;
		updateUI();
		repaint();
	}

	private void doRefresh() {
		// 只有进行过查询，sqlWhere才会被置为非空值。此时进行refresh才有意义
		if (sqlWhere != null) {
			initData();
		}

		int selectRow = getExchangeTablePane().getTable().getRowCount() - 1;
		if (selectRow >= 0) {
			// 刷新后焦点在第一行第一列
			getExchangeTablePane().getTable().addRowSelectionInterval(0, 0);
			getExchangeTablePane().getTable().addColumnSelectionInterval(0, 0);
			getExchangeTablePane().getTable().scrollRectToVisible(
					new Rectangle(0, 0));
		}
	}

	/**
	 * 测试方法
	 * 
	 * @throws ClassNotFoundException
	 */
	private void doTest() {
		PubExchangeUtil pubExchangeUtil = new PubExchangeUtil();
		ArrayList arrayList = new ArrayList<>();
		try {
			Object obj1 = NCLocator.getInstance().lookup(IUAPQueryBS.class)
					.retrieveByPK(OrderHeaderVO.class, "1001A11000000000438I");
			Object obj2 = NCLocator.getInstance().lookup(IUAPQueryBS.class)
					.retrieveByPK(OrderHeaderVO.class, "1001A1100000000043N3");
			Object obj3 = NCLocator.getInstance().lookup(IUAPQueryBS.class)
					.retrieveByPK(OrderHeaderVO.class, "1001A1100000000043NG");
			arrayList.add(obj1);
			arrayList.add(obj2);
			arrayList.add(obj3);
			try {
				ArrayList<String> tansFormat = pubExchangeUtil.tansFormat("1",
						"1", "po_order", arrayList);
				System.out.println("tansFormat:\n" + tansFormat.toString());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean doSave() {
		try {
			saveData();
		} catch (BusinessException e) {
			Logger.error(e.getMessage(), e);
			if (e instanceof VersionConflictException) {
				MessageDialog.showErrorDlg(
						this,
						NCLangRes.getInstance().getStrByID("pfworkflow",
								"UPPpfworkflow-000237")/* 错误 */,
						((VersionConflictException) e).getBusiObject()
								.toString());
			} else {
				MessageDialog.showErrorDlg(
						this,
						NCLangRes.getInstance().getStrByID("pfworkflow",
								"UPPpfworkflow-000237")/* 错误 */,
						e.getMessage());
			}
			return false;
		}

		// 设置按钮
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();

		return true;
	}

	/**
	 * 更新插入的数据TS字段。
	 * */
	@SuppressWarnings("deprecation")
	private void initData(ExchangeVO changeVO) {
		int row = getExchangeTable().getSelectedRow();
		if (row >= 0) {
			getExchangeTableModel().removeVO(row);
		}
		try {
			changeVO = NCLocator.getInstance().lookup(IExchange.class)
					.loadExistExchangeVOWithDetail(changeVO);
			getExchangeTableModel().addVO(changeVO);
		} catch (BusinessException e) {
			Logger.error(e.getMessage(), e);
			showErrorMessage("查询数据交换信息错误：\n" + e.getMessage());
		}

		// 设置浏览态的UI
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
	}

	private void saveData() throws BusinessException {
		if (getExchangeTable().getCellEditor() != null)
			getExchangeTable().getCellEditor().stopCellEditing();

		// 获得VO
		ExchangeVO changeVO = (ExchangeVO) getExchangeTableModel().getVO(
				getExchangeTable().getSelectedRow());

		// 检查VO
		checkVO(changeVO);

		// 保存或更新VO
		if (!StringUtil.isEmpty(changeVO.getPrimaryKey())) {
			ExchangeVO sourceExchangeVO = (ExchangeVO) NCLocator
					.getInstance()
					.lookup(IUAPQueryBS.class)
					.retrieveByPK(ExchangeVO.class,
							changeVO.getPk_apiplat_trans());
			if (!sourceExchangeVO.getNc_bill_type().equals(
					changeVO.getNc_bill_type())) {
				int result = MessageDialog.showOkCancelDlg(null, "警告",
						"更改NC单据类型将会清空转换规则明细数据");
				if (result == nc.ui.pub.beans.UIDialog.ID_CANCEL) {// 取消
					return;
				}
			}
		}
		// 后台数据保存
		changeVO = NCLocator.getInstance().lookup(IExchange.class)
				.saveExchangeVOWithQuery(changeVO);
		initData(changeVO);
	}

	private void checkVO(ExchangeVO changeVO) throws BusinessException {
		// 1.非空
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_code())) {
			throw new PFBusinessException("外系统编码不能为空");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_name())) {
			throw new PFBusinessException("外系统名称不能为空");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_bill_name())) {
			throw new PFBusinessException("外系统单据名称不能为空");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_bill_code())) {
			throw new PFBusinessException("外系统单据编码不能为空");
		}
		// if (StringUtil.isEmptyWithTrim(changeVO.getDefault_trans_rule())) {
		// throw new PFBusinessException("默认翻译规则不能为空");
		// }
		if (StringUtil.isEmptyWithTrim(changeVO.getTrans_style())) {
			throw new PFBusinessException("数据交换格式不能为空");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getNc_bill_type())) {
			throw new PFBusinessException("NC系统单据类型不能为空");
		}
		// 2.校验数据是否重复
		checkDuplicate(changeVO);
	}

	/**
	 * 重复数据校验规则：ext_code+ext_bill_code+nc_bill_type确定唯一性
	 * 
	 * @param vo
	 * @throws PFBusinessException
	 */
	private void checkDuplicate(ExchangeVO vo) throws PFBusinessException {

		String sql = null;

		String ext_code = vo.getExt_code() == null ? "~" : vo.getExt_code();
		String ext_bill_code = vo.getExt_bill_code() == null ? "~" : vo
				.getExt_bill_code();
		String nc_bill_type = vo.getNc_bill_type() == null ? "~" : vo
				.getNc_bill_type();

		String s = "isnull(ext_code, '~')='" + ext_code
				+ "' and isnull(ext_bill_code, '~')='" + ext_bill_code
				+ "' and isnull(nc_bill_type, '~')='" + nc_bill_type + "'";

		Collection<ExchangeVO> c = null;
		try {
			c = NCLocator.getInstance().lookup(IUAPQueryBS.class)
					.retrieveByClause(ExchangeVO.class, s);
		} catch (BusinessException e) {
			throw new PFBusinessException("校验数据交换信息出错");
		}

		if (c != null) {
			if (vo.getPrimaryKey() == null) { // 新增
				if (c.size() <= 0)
					return;
			} else { // 修改
				if (c.size() <= 1)
					return;
			}
			throw new PFBusinessException(getUniqueHitMsg(c));
		}
	}

	/**
	 * 解析重复数据错误明细信息
	 * 
	 * @param c
	 * @return
	 */
	private String getUniqueHitMsg(Collection<ExchangeVO> c) {
		StringBuffer sb = new StringBuffer("接口平台数据转换规则重复");
		for (ExchangeVO evo : c) {
			sb.append("[");
			sb.append("外系统编码" + ":" + toStringWithNull(evo.getExt_code()));
			sb.append("," + "外系统单据编码" + ":"
					+ toStringWithNull(evo.getExt_bill_code()));
			sb.append("," + "NC系统单据类型" + ":"
					+ toStringWithNull(evo.getNc_bill_type()));
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
	}

	private String toStringWithNull(String value) {
		return StringUtils.isNotBlank(value) ? value : NCLangRes.getInstance()
				.getStrByID("org",
						"OrgRelationMultiplicityUniqueRuleValidate-000005")/* 空 */;
	}

	private void doDelete() {
		// 先判断是否可以删除
		int iSelectRow = getExchangeTable().getSelectedRow();
		if (iSelectRow < 0) {
			showErrorMessage(NCLangRes.getInstance().getStrByID("101202",
					"UPP101202-000003")/* 必须选择一行 */);
			return;
		}

		if (MessageDialog.showYesNoDlg(
				this,
				NCLangRes.getInstance().getStrByID("pfworkflow",
						"UPPpfworkflow-000227")/* 提示 */,
				NCLangRes.getInstance().getStrByID("pfworkflow",
						"UPPpfworkflow-000091")/* 系统无法确认该规则是否被使用，请确认是否删除? */) != UIDialog.ID_YES)
			return;
		ExchangeVO exchangeVO = (ExchangeVO) getExchangeTableModel().getVO(
				iSelectRow);
		try {
			// 远程数据删除
			NCLocator.getInstance().lookup(IExchange.class)
					.deleteExchangeVO(exchangeVO);
			getExchangeTableModel().removeVO(iSelectRow);
		} catch (Exception e) {
			getExceptionHandler().handlerExeption(e);
		}
	}

	private IExceptionHandler exceptionHandler = null;

	public IExceptionHandler getExceptionHandler() {
		if (exceptionHandler == null) {
			exceptionHandler = new ExceptionHandlerWithDLG(this);
		}
		return exceptionHandler;
	}

	private void doEdit() {
		// 先判断是否可以删除
		m_rowNumber = getExchangeTable().getSelectedRow();
		if (m_rowNumber < 0) {
			showErrorMessage(NCLangRes.getInstance().getStrByID("101202",
					"UPP101202-000003")/* 必须选择一行 */);
			return;
		}
		// 更新UI状态
		m_uiStatus = UIStatusEnum.EDIT;
		setUIState();
	}

	private void doNew() {
		getExchangeTableModel().addVO(new ExchangeVO());

		m_rowNumber = getExchangeTable().getRowCount() - 1;
		getExchangeTable().setRowSelectionInterval(m_rowNumber, m_rowNumber);

		// yanke1+ 将exhcangeTable所在的scrollPane滚动至末端
		getExchangeTable().scrollRectToVisible(
				getExchangeTable().getCellRect(m_rowNumber, 0, false));

		// 更新UI状态
		m_uiStatus = UIStatusEnum.ADD;
		setUIState();

	}

	private IUAPQueryBS getUAPQry() {
		if (uapQryService == null) {
			uapQryService = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		}

		return uapQryService;
	}

	/**
	 * 设置按钮状态。
	 */
	public void setUIState() {
		if (m_uiStatus == UIStatusEnum.NOT_EDIT) {
			// 浏览态
			m_boQuery.setEnabled(true);
			m_boNew.setEnabled(true);
			m_boEdit.setEnabled(true);
			m_boDelete.setEnabled(true);
			m_boCancel.setEnabled(false);
			m_boSave.setEnabled(false);
			m_boBillMapping.setEnabled(true);
			m_boRefresh.setEnabled(true);
			m_boDelete.setEnabled(true);
			setButtons(m_boGroup);
		} else if (m_uiStatus == UIStatusEnum.EDIT) {
			// 编辑态
			m_boQuery.setEnabled(false);
			m_boNew.setEnabled(false);
			m_boEdit.setEnabled(false);
			m_boDelete.setEnabled(true);
			m_boCancel.setEnabled(true);
			m_boSave.setEnabled(true);
			m_boBillMapping.setEnabled(false);
			m_boRefresh.setEnabled(false);
			m_boDelete.setEnabled(false);
			setButtons(m_boEditGroup);
		} else if (m_uiStatus == UIStatusEnum.ADD) {
			// 新增态
			m_boQuery.setEnabled(false);
			m_boNew.setEnabled(false);
			m_boEdit.setEnabled(false);
			m_boDelete.setEnabled(true);
			m_boCancel.setEnabled(true);
			m_boSave.setEnabled(true);
			m_boBillMapping.setEnabled(false);
			m_boRefresh.setEnabled(false);
			m_boDelete.setEnabled(false);
			setButtons(m_boEditGroup);
		}

		getExchangeTableModel().setUIStatus(m_uiStatus);
		updateButtons();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;
		if (m_uiStatus == UIStatusEnum.ADD || m_uiStatus == UIStatusEnum.EDIT) {
			// 增加或者编辑状态下不能切换表格行
			if (getExchangeTable().getSelectedRow() >= 0)// 选中行才能设置，否则因为删除行而没有选中行时出现异常
				getExchangeTable().setRowSelectionInterval(m_rowNumber,
						m_rowNumber);
		}

		m_rowNumber = getExchangeTable().getSelectedRow();
	}

	@Override
	public boolean onClosing() {

		if (m_uiStatus == UIStatusEnum.EDIT || m_uiStatus == UIStatusEnum.ADD
				|| m_uiStatus == UIStatusEnum.EDIT_RULE) {

			int result = MessageDialog.showYesNoCancelDlg(
					this,
					NCLangRes.getInstance().getStrByID("wfusergroup",
							"WfUserGroupManagerUI-000000")/* 关闭确认 */,
					NCLangRes.getInstance().getStrByID("wfusergroup",
							"WfUserGroupManagerUI-000001")/*
														 * 当前正在编辑的内容尚未保存， 是否保存？
														 */);

			switch (result) {
			case UIDialog.ID_YES:
				if (m_uiStatus == UIStatusEnum.EDIT) {
					return doSave();
				} else if (m_uiStatus == UIStatusEnum.EDIT_RULE) {
					return doSaveBillMapping();
				}
			case UIDialog.ID_NO:
				return true;
			case UIDialog.ID_CANCEL:
				return false;
			}
		}
		return true;
	}
}
