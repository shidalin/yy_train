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
 * �ӿ�ƽ̨����ת��UI-�б���� <br/>
 * shidl@yonyou.com<br/>
 * 2018/04/10<br/>
 * 
 * 
 * ����ְ���漰�����ݿ�� <br/>
 * ְ��sm_responsibility <br/>
 * ְ��_���ܣ�sm_resp_func
 */
public class BillMappingUI extends PFToftPanel implements ListSelectionListener {

	// ��ǰUI�ı༭״̬����ʼΪ���̬
	private UIStatusEnum m_uiStatus = UIStatusEnum.NOT_EDIT;

	private ButtonObject m_boQuery = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "PfExptlogUI-000002")/* ��ѯ */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000000")/* ��ѯ����VO�������� */, 2, "Query"/* ��ѯ */);

	private ButtonObject m_boNew = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "BillMappingUI-000001")/* ���� */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000002")/* ��������VO�������� */, 2, "New"/* ���� */);

	private ButtonObject m_boDelete = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "DeleteLabel")/* ɾ�� */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000003")/* ɾ������VO�������� */, 2, "Delete"/* ɾ�� */);

	private ButtonObject m_boEdit = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "EditCellLabel")/* �༭ */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "EditCellLabel")/* �༭ */,
			2, "Edit"/* �༭ */);

	private ButtonObject m_boBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000004")/* ���ù��� */, NCLangRes.getInstance()
					.getStrByID("pfworkflow", "BillMappingUI-000004")/* ���ù��� */,
			2, "BillMapping"/* ���ù��� */);

	private ButtonObject m_boRefresh = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "UfWorkflowDesignerUI-000000")/* ˢ�� */,
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"UfWorkflowDesignerUI-000000")/* ˢ�� */, 2, "Refresh"/* ˢ�� */);

	private ButtonObject m_boTest = new ButtonObject("����", "����", 2, "Test");

	private ButtonObject m_boSave = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "saveBtnName")/* ���� */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "saveBtnName")/* ���� */, 2,
			"Save"/* ���� */);

	private ButtonObject m_boCancel = new ButtonObject(NCLangRes.getInstance()
			.getStrByID("pfworkflow", "cancelBtnName")/* ȡ�� */, NCLangRes
			.getInstance().getStrByID("pfworkflow", "cancelBtnName")/* ȡ�� */,
			2, "Cancel"/* ȡ�� */);

	private SeparatorButtonObject m_boSeparator = new SeparatorButtonObject();

	// ������˵���ť
	private ButtonObject[] m_boGroup = { m_boNew, m_boEdit, m_boDelete,
			m_boSeparator, m_boQuery, m_boRefresh, m_boSeparator,
			m_boBillMapping, m_boTest };

	private ButtonObject[] m_boEditGroup = { m_boSave, m_boCancel };

	private ButtonObject m_boCancelBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000005")/* ȡ�����ù��� */, NCLangRes
					.getInstance().getStrByID("pfworkflow",
							"BillMappingUI-000005")/* ȡ�����ù��� */, 2,
			"CancelBillMapping"/* ȡ�����ù��� */);

	private ButtonObject m_boSaveBillMapping = new ButtonObject(
			NCLangRes.getInstance().getStrByID("pfworkflow",
					"BillMappingUI-000006")/* ���潻������ */, NCLangRes
					.getInstance().getStrByID("pfworkflow",
							"BillMappingUI-000006")/* ���潻������ */, 2,
			"SaveBillMapping"/* ���潻������ */);

	// �����������˵���ť
	private ButtonObject[] m_boGroupMapping = { m_boSaveBillMapping,
			m_boCancelBillMapping };

	private UITablePane exchangeTablePane;

	private ExchangeTableModel exchangeTableModel;

	private IUAPQueryBS uapQryService = null;

	// ��ѯ�����Ի���
	private QueryConditionDLG qcd = null;

	// ����ת�������ѯģ��
	private TemplateInfo tempinfo = null;

	// ��ǰ��ѯ����
	private String sqlWhere = null;

	// ��ǰ�༭��
	private int m_rowNumber = 0;

	private BillMappingPane m_billMappingPane;

	// ��ǰ�򿪽ڵ��Ƿ��ڿ���ƽ̨�£������ڿ���ƽ̨�£���Ĭ�Ͼ��Ǽ��ż��ģ������ϲ���ʾ�����ż�������ѡ���
	private UFBoolean isglobal;

	public BillMappingUI() {
		super();
	}

	public void init() {
		// ���ð�ť
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

		// Ĭ�������ˢ�°�ť������
		m_boRefresh.setEnabled(false);
		// ���԰�ť
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
	 * ��ʼ���༭���
	 */
	private void initTableStyle() {
		// Ĭ�Ϸ�������ֶ�
		getExchangeTable()
				.getColumnModel()
				.getColumn(4)
				.setCellEditor(
						new DefaultCellEditor(getExchangeTableModel()
								.getCombDefaultTransRule()));
		// ���ݽ�����ʽ�ֶ�
		getExchangeTable()
				.getColumnModel()
				.getColumn(5)
				.setCellEditor(
						new DefaultCellEditor(getExchangeTableModel()
								.getCombTransStyle()));
		// NCϵͳ���������ֶ�
		getExchangeTable()
				.getColumnModel()
				.getColumn(6)
				.setCellEditor(
						new UIRefCellEditor(getExchangeTableModel()
								.getNCBillTypeRef()));
	}

	private void initData() {

		getExchangeTableModel().clearTable();

		// sqlWhereϵ��ѯ�Ի������ɵ�sql condition���
		// ����ѯ�Ի�����δ�����κ���������˴�sqlWhere��Ϊnull
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
			showErrorMessage("��ѯ�ӿ�ƽ̨����ת������ʧ��");
		}

		// �������̬��UI
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
			// ��ǰѡ���в��ܱ༭
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
	 * ���ز�ѯģ����Ϣ
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
				"UPPpfworkflow-000586")/* ���ݽ������� */;
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
			// ��ѯ��ˢ�°�ť����
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

		// XXX:һ�����棬���ص�������
		doCancelBillMapping();

		return true;
	}

	private void doCancelBillMapping() {
		// �л�UI
		getBillMappingPane().cancelEditing();

		remove(getBillMappingPane());
		add(getExchangeTablePane());
		// ���ð�ť
		setButtons(m_boGroup);
		//
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
		repaint();
	}

	private void doCancel() {
		// ֹͣ�༭
		if (getExchangeTable().getCellEditor() != null) {
			getExchangeTable().getCellEditor().stopCellEditing();
		}

		// ��Ϊ��ӣ���ɾ������ӵ���
		if (m_uiStatus == UIStatusEnum.ADD) {
			getExchangeTableModel().removeVO(m_rowNumber);
		} else if (m_uiStatus == UIStatusEnum.EDIT) { // ��Ϊ�޸ģ��޶���
		}

		// ����UI״̬
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
					"UPP101202-000003")/* ����ѡ��һ�� */);
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
					new String[] { e.getMessage() })/* ��ʼ�����ݽ�����������쳣��{0} */);
			return;
		}
		// �л���������
		this.remove(getExchangeTablePane());
		this.add(getBillMappingPane(), SwingConstants.CENTER);
		// ���ð�ť
		setButtons(m_boGroupMapping);
		m_uiStatus = UIStatusEnum.EDIT_RULE;
		updateUI();
		repaint();
	}

	private void doRefresh() {
		// ֻ�н��й���ѯ��sqlWhere�Żᱻ��Ϊ�ǿ�ֵ����ʱ����refresh��������
		if (sqlWhere != null) {
			initData();
		}

		int selectRow = getExchangeTablePane().getTable().getRowCount() - 1;
		if (selectRow >= 0) {
			// ˢ�º󽹵��ڵ�һ�е�һ��
			getExchangeTablePane().getTable().addRowSelectionInterval(0, 0);
			getExchangeTablePane().getTable().addColumnSelectionInterval(0, 0);
			getExchangeTablePane().getTable().scrollRectToVisible(
					new Rectangle(0, 0));
		}
	}

	/**
	 * ���Է���
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
								"UPPpfworkflow-000237")/* ���� */,
						((VersionConflictException) e).getBusiObject()
								.toString());
			} else {
				MessageDialog.showErrorDlg(
						this,
						NCLangRes.getInstance().getStrByID("pfworkflow",
								"UPPpfworkflow-000237")/* ���� */,
						e.getMessage());
			}
			return false;
		}

		// ���ð�ť
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();

		return true;
	}

	/**
	 * ���²��������TS�ֶΡ�
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
			showErrorMessage("��ѯ���ݽ�����Ϣ����\n" + e.getMessage());
		}

		// �������̬��UI
		m_uiStatus = UIStatusEnum.NOT_EDIT;
		setUIState();
	}

	private void saveData() throws BusinessException {
		if (getExchangeTable().getCellEditor() != null)
			getExchangeTable().getCellEditor().stopCellEditing();

		// ���VO
		ExchangeVO changeVO = (ExchangeVO) getExchangeTableModel().getVO(
				getExchangeTable().getSelectedRow());

		// ���VO
		checkVO(changeVO);

		// ��������VO
		if (!StringUtil.isEmpty(changeVO.getPrimaryKey())) {
			ExchangeVO sourceExchangeVO = (ExchangeVO) NCLocator
					.getInstance()
					.lookup(IUAPQueryBS.class)
					.retrieveByPK(ExchangeVO.class,
							changeVO.getPk_apiplat_trans());
			if (!sourceExchangeVO.getNc_bill_type().equals(
					changeVO.getNc_bill_type())) {
				int result = MessageDialog.showOkCancelDlg(null, "����",
						"����NC�������ͽ������ת��������ϸ����");
				if (result == nc.ui.pub.beans.UIDialog.ID_CANCEL) {// ȡ��
					return;
				}
			}
		}
		// ��̨���ݱ���
		changeVO = NCLocator.getInstance().lookup(IExchange.class)
				.saveExchangeVOWithQuery(changeVO);
		initData(changeVO);
	}

	private void checkVO(ExchangeVO changeVO) throws BusinessException {
		// 1.�ǿ�
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_code())) {
			throw new PFBusinessException("��ϵͳ���벻��Ϊ��");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_name())) {
			throw new PFBusinessException("��ϵͳ���Ʋ���Ϊ��");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_bill_name())) {
			throw new PFBusinessException("��ϵͳ�������Ʋ���Ϊ��");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getExt_bill_code())) {
			throw new PFBusinessException("��ϵͳ���ݱ��벻��Ϊ��");
		}
		// if (StringUtil.isEmptyWithTrim(changeVO.getDefault_trans_rule())) {
		// throw new PFBusinessException("Ĭ�Ϸ��������Ϊ��");
		// }
		if (StringUtil.isEmptyWithTrim(changeVO.getTrans_style())) {
			throw new PFBusinessException("���ݽ�����ʽ����Ϊ��");
		}
		if (StringUtil.isEmptyWithTrim(changeVO.getNc_bill_type())) {
			throw new PFBusinessException("NCϵͳ�������Ͳ���Ϊ��");
		}
		// 2.У�������Ƿ��ظ�
		checkDuplicate(changeVO);
	}

	/**
	 * �ظ�����У�����ext_code+ext_bill_code+nc_bill_typeȷ��Ψһ��
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
			throw new PFBusinessException("У�����ݽ�����Ϣ����");
		}

		if (c != null) {
			if (vo.getPrimaryKey() == null) { // ����
				if (c.size() <= 0)
					return;
			} else { // �޸�
				if (c.size() <= 1)
					return;
			}
			throw new PFBusinessException(getUniqueHitMsg(c));
		}
	}

	/**
	 * �����ظ����ݴ�����ϸ��Ϣ
	 * 
	 * @param c
	 * @return
	 */
	private String getUniqueHitMsg(Collection<ExchangeVO> c) {
		StringBuffer sb = new StringBuffer("�ӿ�ƽ̨����ת�������ظ�");
		for (ExchangeVO evo : c) {
			sb.append("[");
			sb.append("��ϵͳ����" + ":" + toStringWithNull(evo.getExt_code()));
			sb.append("," + "��ϵͳ���ݱ���" + ":"
					+ toStringWithNull(evo.getExt_bill_code()));
			sb.append("," + "NCϵͳ��������" + ":"
					+ toStringWithNull(evo.getNc_bill_type()));
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
	}

	private String toStringWithNull(String value) {
		return StringUtils.isNotBlank(value) ? value : NCLangRes.getInstance()
				.getStrByID("org",
						"OrgRelationMultiplicityUniqueRuleValidate-000005")/* �� */;
	}

	private void doDelete() {
		// ���ж��Ƿ����ɾ��
		int iSelectRow = getExchangeTable().getSelectedRow();
		if (iSelectRow < 0) {
			showErrorMessage(NCLangRes.getInstance().getStrByID("101202",
					"UPP101202-000003")/* ����ѡ��һ�� */);
			return;
		}

		if (MessageDialog.showYesNoDlg(
				this,
				NCLangRes.getInstance().getStrByID("pfworkflow",
						"UPPpfworkflow-000227")/* ��ʾ */,
				NCLangRes.getInstance().getStrByID("pfworkflow",
						"UPPpfworkflow-000091")/* ϵͳ�޷�ȷ�ϸù����Ƿ�ʹ�ã���ȷ���Ƿ�ɾ��? */) != UIDialog.ID_YES)
			return;
		ExchangeVO exchangeVO = (ExchangeVO) getExchangeTableModel().getVO(
				iSelectRow);
		try {
			// Զ������ɾ��
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
		// ���ж��Ƿ����ɾ��
		m_rowNumber = getExchangeTable().getSelectedRow();
		if (m_rowNumber < 0) {
			showErrorMessage(NCLangRes.getInstance().getStrByID("101202",
					"UPP101202-000003")/* ����ѡ��һ�� */);
			return;
		}
		// ����UI״̬
		m_uiStatus = UIStatusEnum.EDIT;
		setUIState();
	}

	private void doNew() {
		getExchangeTableModel().addVO(new ExchangeVO());

		m_rowNumber = getExchangeTable().getRowCount() - 1;
		getExchangeTable().setRowSelectionInterval(m_rowNumber, m_rowNumber);

		// yanke1+ ��exhcangeTable���ڵ�scrollPane������ĩ��
		getExchangeTable().scrollRectToVisible(
				getExchangeTable().getCellRect(m_rowNumber, 0, false));

		// ����UI״̬
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
	 * ���ð�ť״̬��
	 */
	public void setUIState() {
		if (m_uiStatus == UIStatusEnum.NOT_EDIT) {
			// ���̬
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
			// �༭̬
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
			// ����̬
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
			// ���ӻ��߱༭״̬�²����л������
			if (getExchangeTable().getSelectedRow() >= 0)// ѡ���в������ã�������Ϊɾ���ж�û��ѡ����ʱ�����쳣
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
							"WfUserGroupManagerUI-000000")/* �ر�ȷ�� */,
					NCLangRes.getInstance().getStrByID("wfusergroup",
							"WfUserGroupManagerUI-000001")/*
														 * ��ǰ���ڱ༭��������δ���棬 �Ƿ񱣴棿
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
