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
		// ���뵼��������Զ�����ֶ�
		if (this.getBillcardPanelEditor() != null) {
			// ��Ҫ�����ı�����
			BillData bd = this.getBillcardPanelEditor().getBillCardPanel()
					.getBillData();
			// ���뵼���ı�ͷ�����֯�ֶ�
			BillItem orgItem = bd.getHeadItem("pk_org");
			// ��¡һ���µ�BillItem���в��������ƻ�ԭ��BillItem������
			BillItem orgItem2 = new BillItem(orgItem.toBillTempletBodyVO());
			orgItem2.setEdit(true);
			orgItem2.setShow(true);
			orgItem2.setNull(true);
			result.add(new BillItemValue(orgItem2));
			// ���뵼���ı�������к��ֶ�
			BillItem rowItem = bd.getBodyItem("crowno");
			// ��¡һ���µ�BillItem���в��������ƻ�ԭ��BillItem������
			BillItem rowItem2 = new BillItem(rowItem.toBillTempletBodyVO());
			rowItem2.setEdit(true);
			rowItem2.setShow(true);
			rowItem2.setNull(true);
			result.add(new BillItemValue(rowItem2));
		}
		return result;
	}
}
