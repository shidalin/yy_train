package nc.ui.train.orders.ace.handler;

import nc.pub.train.util.BodySumUtil;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.ui.pubapp.uif2app.view.util.RefMoreSelectedUtils;
import nc.vo.pub.lang.UFDouble;

public class AceBodyAfterEditHandler implements
		IAppEventHandler<CardBodyAfterEditEvent> {

	@Override
	public void handleAppEvent(CardBodyAfterEditEvent e) {
		String key = e.getKey();
		int row = e.getRow();
		BillCardPanel cpanel = e.getBillCardPanel();
		// ���ն�ѡ����
		RefMoreSelectedUtils utils = new RefMoreSelectedUtils(cpanel);
		utils.refMoreSelected(row, key, true);
		// ������
		if ("nnum".equals(key) || "nprice".equals(key)) {
			BodySumUtil.BodySum(cpanel);
		}
		UFDouble nnum = (UFDouble) cpanel.getBodyValueAt(row, "nnum");
		UFDouble nprice = (UFDouble) cpanel.getBodyValueAt(row, "nprice");
		UFDouble nmny = UFDouble.ZERO_DBL;
		if (null == nnum) {
			nnum = UFDouble.ZERO_DBL;
		}
		if (null == nprice) {
			nprice = UFDouble.ZERO_DBL;
		}
		nmny = nnum.multiply(nprice);
		cpanel.setBodyValueAt(nmny, row, "nmny");

	}
}
