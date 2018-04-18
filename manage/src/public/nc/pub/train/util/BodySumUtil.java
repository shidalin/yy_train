package nc.pub.train.util;

import nc.ui.pub.bill.BillCardPanel;
import nc.vo.pub.lang.UFDouble;

public class BodySumUtil {
	
	public static void BodySum (BillCardPanel cpanel) {
		
		int count = cpanel.getBillModel().getRowCount();
	
		UFDouble ntotalmny = UFDouble.ZERO_DBL;
		UFDouble ntotalnum = UFDouble.ZERO_DBL;
		
		for (int i = 0; i < count; i ++) {
			UFDouble nnum = (UFDouble)cpanel.getBodyValueAt(i, "nnum");
			UFDouble nprice = (UFDouble)cpanel.getBodyValueAt(i, "nprice");
			if (null == nnum) {
				nnum = UFDouble.ZERO_DBL;
			}
			if (null == nprice) {
				nprice = UFDouble.ZERO_DBL;
			}
			ntotalmny = ntotalmny.add(nnum.multiply(nprice));
			ntotalnum = ntotalnum.add(nnum);
		}
		cpanel.setHeadItem("ntotalmny", ntotalmny);
		cpanel.setHeadItem("ntotalnum", ntotalnum);
	}
}
