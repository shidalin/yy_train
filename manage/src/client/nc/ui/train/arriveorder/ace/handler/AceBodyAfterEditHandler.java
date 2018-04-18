package nc.ui.train.arriveorder.ace.handler;

import nc.pub.train.util.BodySumUtil;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.AppContext;
/**
 *单据表体字段编辑后事件
 * 
 * @since 6.0
 * @version 2011-7-12 下午08:17:33
 * @author duy
 */
public class AceBodyAfterEditHandler implements IAppEventHandler<CardBodyAfterEditEvent> {

    @Override
    public void handleAppEvent(CardBodyAfterEditEvent e) {


    	BillCardPanel cpanel = e.getBillCardPanel();
    	String key = e.getKey();
    	
    	if ("nnum".equals(key) || "nprice".equals(key)) {
    		BodySumUtil.BodySum(cpanel);
    	}
    	int row = e.getRow();
		UFDouble nnum = (UFDouble)cpanel.getBodyValueAt(row, "nnum");
		UFDouble nprice = (UFDouble)cpanel.getBodyValueAt(row, "nprice");
		UFDouble nmny = UFDouble.ZERO_DBL;
		if (null == nnum) {
			nnum = UFDouble.ZERO_DBL;
		}
		if (null == nprice) {
			nprice = UFDouble.ZERO_DBL;
		}
		nmny = nnum.multiply(nprice);
		cpanel.setBodyValueAt(nmny, row, "nmny");
		
		//获取当前登陆用户权限组织
		
		String currentUser = AppContext.getInstance().getPkUser();
		
		
    }

}
