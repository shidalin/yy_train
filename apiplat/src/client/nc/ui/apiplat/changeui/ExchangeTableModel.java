package nc.ui.apiplat.changeui;

import javax.swing.JTable;

import nc.ui.pf.changeui.UIStatusEnum;
import nc.ui.pf.multilang.PfMultiLangUtil;
import nc.ui.pf.pub.AllBillRefModel;
import nc.ui.pub.beans.UIComboBox;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.beans.table.VOTableModel;
import nc.vo.apiplat.exchange.DefaultTransRuleEnum;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.apiplat.exchange.TransStyleEnum;

/**
 * 接口平台数据转换 主表 表格模型<br/>
 * shidl@yonyou.com<br/>
 * 2018/04/12<br/>
 */
public class ExchangeTableModel extends VOTableModel {

	private String[] columnNames = new String[] { "外系统编码", "外系统名称", "外系统单据编码",
			"外系统单据名称", "默认翻译规则", "数据交换格式", "NC系统单据类型" };

	private int[] columnWidths = new int[] { 150, 150, 150, 150, 120, 120, 120 };

	// NC单据类型参照
	private UIRefPane ncBillTypeRef = new UIRefPane();

	private UIStatusEnum m_uiStatus;

	private UIComboBox combDefaultTransRule = null;
	private UIComboBox combTransStyle = null;

	private JTable table;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public UIRefPane getNCBillTypeRef() {
		return ncBillTypeRef;
	}

	public int[] getColWidths() {
		return this.columnWidths;
	}

	public ExchangeTableModel(Class c) {
		super(c);
		initRefEditors();
	}

	public UIComboBox getCombDefaultTransRule() {
		if (combDefaultTransRule == null) {
			combDefaultTransRule = new UIComboBox();
			combDefaultTransRule.addItems(DefaultTransRuleEnum.values());
		}
		return combDefaultTransRule;
	}

	public UIComboBox getCombTransStyle() {
		if (combTransStyle == null) {
			combTransStyle = new UIComboBox();
			combTransStyle.addItems(TransStyleEnum.values());
		}
		return combTransStyle;
	}

	/**
	 * 初始化编辑面板
	 */
	private void initRefEditors() {
		ncBillTypeRef.setIsCustomDefined(true);
		// 元数据参照 nc.ui.md.ref.MDMainEntityTreeModel
		// 单据类型参照
		nc.ui.md.ref.MDMainEntityTreeModel ncBillrefModel = new nc.ui.md.ref.MDMainEntityTreeModel();
		ncBillTypeRef.setRefModel(ncBillrefModel);
		ncBillTypeRef.setReturnCode(true);
		// 初始化参照的where子句
		initRefEditorClause();
	}

	// 初始化参照的where子句
	private void initRefEditorClause() {
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * 获取VO字段值
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		ExchangeVO exchangeVO = (ExchangeVO) getVO(rowIndex);
		Object obj = null;

		switch (columnIndex) {
		case 0:
			obj = exchangeVO.getExt_code();
			break;
		case 1:
			obj = exchangeVO.getExt_name();
			break;
		case 2:
			obj = exchangeVO.getExt_bill_code();
			break;
		case 3:
			obj = exchangeVO.getExt_bill_name();
			break;
		case 4:
			obj = (exchangeVO.getDefault_trans_rule() == null || exchangeVO
					.getDefault_trans_rule() == "") ? "" : DefaultTransRuleEnum
					.fromInt(Integer.parseInt(exchangeVO
							.getDefault_trans_rule()));
			break;
		case 5:
			obj = exchangeVO.getTrans_style() == null ? "" : TransStyleEnum
					.fromInt(Integer.parseInt(exchangeVO.getTrans_style()));
			break;
		case 6:
			obj = exchangeVO.getNc_bill_type();
			break;
		}
		return obj;
	}

	public void setValueAt(Object aValue, int row, int column) {
		super.setValueAt(aValue, row, column);

		ExchangeVO changeVO = (ExchangeVO) getVO(row);
		if (changeVO == null)
			return;
		switch (column) {
		case 0:
			if (aValue != null) {
				changeVO.setExt_code((String) aValue);
			}
			break;
		case 1:
			if (aValue != null) {
				changeVO.setExt_name((String) aValue);
			}
			break;
		case 2:
			if (aValue != null) {
				changeVO.setExt_bill_code((String) aValue);
			}
			break;
		case 3:
			if (aValue != null) {
				changeVO.setExt_bill_name((String) aValue);
			}
			break;
		case 4:
			DefaultTransRuleEnum rt = (DefaultTransRuleEnum) getCombDefaultTransRule()
					.getSelectedItem();
			changeVO.setDefault_trans_rule(((Integer) rt.toInt()).toString());
			break;
		case 5:
			TransStyleEnum ts = (TransStyleEnum) getCombTransStyle()
					.getSelectedItem();
			changeVO.setTrans_style(((Integer) ts.toInt()).toString());
			break;
		case 6:
			if (ncBillTypeRef != null) {
				ncBillTypeRef.setBlurValue(ncBillTypeRef.getUITextField()
						.getText());
				changeVO.setNc_bill_type(ncBillTypeRef.getRefCode());
			}
			break;
		}
	}

	/**
	 * 面板编辑性处理
	 */
	public boolean isCellEditable(int row, int col) {
		// 非选中行，不可编辑
		// if(!isRowEditable(row))
		// return false;
		if (table != null && table.getSelectedRow() != row) {
			return false;
		}
		ExchangeVO changeVO = (ExchangeVO) getVO(row);
		if (m_uiStatus == UIStatusEnum.NOT_EDIT) {
			return false;
		} else if (m_uiStatus == UIStatusEnum.EDIT) {
			return true;
		} else if (m_uiStatus == UIStatusEnum.ADD) {
			ncBillTypeRef.setPK(null);
			return true;
		} else
			return false;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public void setUIStatus(UIStatusEnum status) {
		this.m_uiStatus = status;
	}

}
