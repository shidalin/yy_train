package nc.ui.train.arriveorder.ace.editor;

import java.util.List;

import nc.ui.pub.bill.BillData;
import nc.ui.pub.bill.BillItem;
import nc.ui.scmbd.vrm.vm.action.excel.BillItemValue;
import nc.ui.trade.excelimport.InputItem;
import nc.ui.uif2.excelimport.DefaultUIF2ImportableEditor;

public class KeyNodePlanImportPanel extends DefaultUIF2ImportableEditor {
	@Override
	public List<InputItem> getInputItems() {
		List<InputItem> result = super.getInputItems();
		// 导入导出中添加自定义的字段
		if (this.getBillcardPanelEditor() != null) {
			// 需要导出的表单数据
			BillData bd = this.getBillcardPanelEditor().getBillCardPanel()
					.getBillData();
			// 导入导出的表头添加组织字段
			BillItem orgItem = bd.getHeadItem("pk_org");
			// 克隆一个新的BillItem进行操作，不破坏原有BillItem的属性
			BillItem orgItem2 = new BillItem(orgItem.toBillTempletBodyVO());
			orgItem2.setEdit(true);
			orgItem2.setShow(true);
			orgItem2.setNull(true);
			result.add(new BillItemValue(orgItem2));
			// 导入导出的表体添加行号字段
			BillItem rowItem = bd.getBodyItem("crowno");
			// 克隆一个新的BillItem进行操作，不破坏原有BillItem的属性
			BillItem rowItem2 = new BillItem(rowItem.toBillTempletBodyVO());
			rowItem2.setEdit(true);
			rowItem2.setShow(true);
			rowItem2.setNull(true);
			result.add(new BillItemValue(rowItem2));
		}
		return result;
	}
}
