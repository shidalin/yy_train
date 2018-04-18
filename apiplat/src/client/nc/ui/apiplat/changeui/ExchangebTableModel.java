package nc.ui.apiplat.changeui;

import nc.ui.pf.changeui.AssignRuleEditor;
import nc.ui.pf.changeui.FormulaRuleEditor;
import nc.ui.pf.changeui.MoveRuleEditor;
import nc.ui.pub.beans.UIComboBox;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.table.VOTableModel;
import nc.vo.apiplat.exchange.DefaultTransRuleEnum;
import nc.vo.apiplat.exchange.ExchangeRuleVO;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.apiplat.exchange.TransLogicStyleEnum;

/**
 * 接口平台数据转换 子表 表格模型<br/>
 * shidl@yonyou.com<br/>
 * 2018/04/12<br/>
 */
public class ExchangebTableModel extends VOTableModel {
	private String[] columnNames = new String[] { "NC属性编码", "NC属性名称",
			"NC属性是否必输", "交换类型", "翻译规则", "翻译SQL/默认值", "外系统属性编码", "外系统属性名称" };

	private int[] columnWidths = new int[] { 200, 200, 100, 100, 100, 200, 200,
			200 };

	private UIComboBox combTransLogicStyle = null;
	private UIComboBox combTransRule = null;

	private AssignRuleEditor assignEditor = null;

	private UITable containTable;

	private FormulaRuleEditor formulaEditor;

	private MoveRuleEditor moveEditor;

	private ExchangeVO curExchangeVO; // 当前正编辑的单据交换信息VO

	public ExchangebTableModel(Class c) {
		super(c);
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ExchangeRuleVO ruleVO = (ExchangeRuleVO) getVO(rowIndex);
		Object aValue = null;
		switch (columnIndex) {
		case 0:
			aValue = ruleVO.getNc_field_code() == null ? "" : ruleVO
					.getNc_field_code();
			break;
		case 1:
			aValue = ruleVO.getNc_field_name() == null ? "" : ruleVO
					.getNc_field_name();
			break;
		case 2:
			aValue = ruleVO.getNc_field_isrequire() == null ? "" : ruleVO
					.getNc_field_isrequire();
			break;
		case 3:
			aValue = ruleVO.getTrans_logic_style() == null ? ""
					: TransLogicStyleEnum.fromInt(Integer.parseInt(ruleVO
							.getTrans_logic_style()));
			break;
		case 4:
			aValue = (ruleVO.getTrans_rule() == null || "".equals(ruleVO
					.getTrans_rule().trim())) ? "" : DefaultTransRuleEnum
					.fromInt(Integer.parseInt(ruleVO.getTrans_rule()));
			break;
		case 5:
			aValue = ruleVO.getTrans_sql() == null ? "" : ruleVO.getTrans_sql();
			break;
		case 6:
			aValue = ruleVO.getExt_field_code() == null ? "" : ruleVO
					.getExt_field_code();
			break;
		case 7:
			aValue = ruleVO.getExt_field_name() == null ? "" : ruleVO
					.getExt_field_name();
			break;
		default:
			break;
		}
		return aValue;
	}

	public void setValueAt(Object aValue, int row, int column) {
		super.setValueAt(aValue, row, column);
		ExchangeRuleVO ruleVO = (ExchangeRuleVO) getVO(row);
		switch (column) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			TransLogicStyleEnum tls = (TransLogicStyleEnum) getCombTransLogicStyle()
					.getSelectedItem();
			ruleVO.setTrans_logic_style(((Integer) tls.toInt()).toString());
			break;
		case 4:
			DefaultTransRuleEnum rt = (DefaultTransRuleEnum) getCombTransRule()
					.getSelectedItem();
			ruleVO.setTrans_rule(((Integer) rt.toInt()).toString());
			break;
		case 5:
			if (aValue != null) {
				ruleVO.setTrans_sql((String) aValue);
			}
			break;
		case 6:
			if (aValue != null) {
				ruleVO.setExt_field_code((String) aValue.toString().trim());
			}
			break;
		case 7:
			if (aValue != null) {
				ruleVO.setExt_field_name((String) aValue);
			}
			break;
		default:
			break;
		}
	}

	public int[] getColWidths() {
		return columnWidths;
	}

	public boolean isCellEditable(int row, int col) {
		ExchangeRuleVO ruleVO = (ExchangeRuleVO) getVO(row);
		if (col == 0 || col == 1 || col == 2) {
			return false;
		}

		return true;
	}

	public UIComboBox getCombTransLogicStyle() {
		if (combTransLogicStyle == null) {
			combTransLogicStyle = new UIComboBox();
			combTransLogicStyle.addItems(TransLogicStyleEnum.values());
		}
		return combTransLogicStyle;
	}

	public UIComboBox getCombTransRule() {
		if (combTransRule == null) {
			combTransRule = new UIComboBox();
			combTransRule.addItems(DefaultTransRuleEnum.values());
		}
		return combTransRule;
	}

	private MoveRuleEditor getMoveEditor() {
		if (moveEditor == null) {
			moveEditor = new MoveRuleEditor();
		}
		return moveEditor;
	}

	private AssignRuleEditor getAssignEditor() {
		if (assignEditor == null) {
			assignEditor = new AssignRuleEditor();
		}
		return assignEditor;
	}

	private FormulaRuleEditor getFormulaEditor() {
		if (formulaEditor == null) {
			formulaEditor = new FormulaRuleEditor();
		}
		return formulaEditor;
	}

	public void setContainTable(UITable table) {
		this.containTable = table;

	}

	public void setCurExchangeVO(ExchangeVO curExchangeVO) {
		this.curExchangeVO = curExchangeVO;
	}
}
