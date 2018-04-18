package nc.bs.train.arriveorder.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.train.AggArriveorderVO;
import nc.vo.pub.VOStatus;

/**
 * 标准单据弃审的BP
 */
public class AceArriveorderUnApproveBP {

	public AggArriveorderVO[] unApprove(AggArriveorderVO[] clientBills,
			AggArriveorderVO[] originBills) {
		for (AggArriveorderVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggArriveorderVO> update = new BillUpdate<AggArriveorderVO>();
		AggArriveorderVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}
}
