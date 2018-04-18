package nc.bs.train.arriveorder.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.pub.VOStatus;
import nc.vo.train.AggArriveorderVO;

/**
 * 标准单据审核的BP
 */
public class AceArriveorderApproveBP {

	/**
	 * 审核动作
	 * 
	 * @param vos
	 * @param script
	 * @return
	 */
	public AggArriveorderVO[] approve(AggArriveorderVO[] clientBills,
			AggArriveorderVO[] originBills) {
		for (AggArriveorderVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggArriveorderVO> update = new BillUpdate<AggArriveorderVO>();
		AggArriveorderVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

}
