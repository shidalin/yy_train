package nc.ui.train.orders.ace.handler;

import nc.ui.pub.beans.UIRefPane;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent;

public class AceHeadTailAfterEditHandler implements
		IAppEventHandler<CardHeadTailAfterEditEvent> {

	@Override
	public void handleAppEvent(CardHeadTailAfterEditEvent e) {
		String editkey = e.getKey();
		// 供应商带出供应商分类
		if ("pk_supplier".equals(e.getKey())) {
			UIRefPane refPanel = (UIRefPane) e.getBillCardPanel()
					.getHeadItem(e.getKey()).getComponent();
			// 获取参照选中的供应商分类的值
			Object pk_supclass_new = refPanel.getRefValue("pk_supclass");
			// 表头设置
			e.getBillCardPanel().getHeadItem("pk_supclass")
					.setValue(pk_supclass_new);
		}
	}

}
