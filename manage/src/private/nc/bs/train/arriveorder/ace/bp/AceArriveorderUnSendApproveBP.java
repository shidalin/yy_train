package nc.bs.train.arriveorder.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.train.AggArriveorderVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼�����ջص�BP
 */
public class AceArriveorderUnSendApproveBP {

	public AggArriveorderVO[] unSend(AggArriveorderVO[] clientBills,
			AggArriveorderVO[] originBills) {
		// ��VO�־û������ݿ���
		this.setHeadVOStatus(clientBills);
		BillUpdate<AggArriveorderVO> update = new BillUpdate<AggArriveorderVO>();
		AggArriveorderVO[] returnVos = update.update(clientBills, originBills);
		return returnVos;
	}

	private void setHeadVOStatus(AggArriveorderVO[] clientBills) {
		for (AggArriveorderVO clientBill : clientBills) {
			clientBill.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.FREE.value());
			clientBill.getParentVO().setStatus(VOStatus.UPDATED);
		}
	}
}
