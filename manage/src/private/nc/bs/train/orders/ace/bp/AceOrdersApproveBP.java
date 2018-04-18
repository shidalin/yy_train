package nc.bs.train.orders.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.pub.VOStatus;
import nc.vo.train.AggOrderVO;

/**
 * ��׼������˵�BP
 */
public class AceOrdersApproveBP {

	/**
	 * ��˶���
	 * 
	 * @param vos
	 * @param script
	 * @return
	 */
	public AggOrderVO[] approve(AggOrderVO[] clientBills,
			AggOrderVO[] originBills) {
		for (AggOrderVO clientBill : clientBills) {
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
		BillUpdate<AggOrderVO> update = new BillUpdate<AggOrderVO>();
		AggOrderVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

}
