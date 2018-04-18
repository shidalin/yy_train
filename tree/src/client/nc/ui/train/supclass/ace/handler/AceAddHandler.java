package nc.ui.train.supclass.ace.handler;

import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillItem;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.vo.train.SupclassVO;

public class AceAddHandler implements IAppEventHandler<AddEvent> {

	@Override
	public void handleAppEvent(AddEvent e) {
		String pk_group = e.getContext().getPk_group();
		String pk_org = e.getContext().getPk_org();
		BillCardPanel panel = e.getBillForm().getBillCardPanel();
		// 设置主组织默认值
		panel.setHeadItem("pk_group", pk_group);
		panel.setHeadItem("pk_org", pk_org);
		// 上级供应商分类处理
		BillItem headItem = e.getBillForm().getBillCardPanel()
				.getHeadItem("parent_id");
		if (e.getBillForm().getModel().getSelectedData() != null) {
			SupclassVO pvo = (SupclassVO) e.getBillForm().getModel()
					.getSelectedData();
			((UIRefPane) (headItem.getComponent())).setPK(pvo.getPk_supclass());
			headItem.setEdit(false);
		} else {
			headItem.setEdit(true);
		}
	}
}
