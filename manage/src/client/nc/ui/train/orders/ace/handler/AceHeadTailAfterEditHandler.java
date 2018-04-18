package nc.ui.train.orders.ace.handler;

import nc.ui.pub.beans.UIRefPane;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent;

public class AceHeadTailAfterEditHandler implements
		IAppEventHandler<CardHeadTailAfterEditEvent> {

	@Override
	public void handleAppEvent(CardHeadTailAfterEditEvent e) {
		String editkey = e.getKey();
		// ��Ӧ�̴�����Ӧ�̷���
		if ("pk_supplier".equals(e.getKey())) {
			UIRefPane refPanel = (UIRefPane) e.getBillCardPanel()
					.getHeadItem(e.getKey()).getComponent();
			// ��ȡ����ѡ�еĹ�Ӧ�̷����ֵ
			Object pk_supclass_new = refPanel.getRefValue("pk_supclass");
			// ��ͷ����
			e.getBillCardPanel().getHeadItem("pk_supclass")
					.setValue(pk_supclass_new);
		}
	}

}
