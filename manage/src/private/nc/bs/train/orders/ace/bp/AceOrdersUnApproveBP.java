package nc.bs.train.orders.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.train.AggOrderVO;
import nc.vo.pub.VOStatus;

/**
 * 标准单据弃审的BP
 */
public class AceOrdersUnApproveBP {

	public AggOrderVO[] unApprove(AggOrderVO[] clientBills,
			AggOrderVO[] originBills) {
		for (AggOrderVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggOrderVO> update = new BillUpdate<AggOrderVO>();
		AggOrderVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}
}
