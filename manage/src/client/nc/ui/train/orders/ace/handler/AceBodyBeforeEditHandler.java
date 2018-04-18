package nc.ui.train.orders.ace.handler;

import java.util.Arrays;

import nc.ui.pub.beans.UIRefPane;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent;

public class AceBodyBeforeEditHandler implements
		IAppEventHandler<CardBodyBeforeEditEvent> {

	@Override
	public void handleAppEvent(CardBodyBeforeEditEvent e) {
		e.setReturnValue(Boolean.TRUE);
		// TODO Auto-generated method stub
		String key = e.getKey();
		String[] keys = new String[] { "pk_material" };
		if (Arrays.asList(keys).contains(key)) {
			UIRefPane panel = (UIRefPane) e.getBillCardPanel().getBodyItem(key)
					.getComponent();
			panel.setMultiSelectedEnabled(true);
		}
	}
}
