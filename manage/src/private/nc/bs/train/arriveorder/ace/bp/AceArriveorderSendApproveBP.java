package nc.bs.train.arriveorder.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.train.AggArriveorderVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼���������BP
 */
public class AceArriveorderSendApproveBP {
	/**
	 * ������
	 * 
	 * @param vos
	 *            ����VO����
	 * @param script
	 *            ���ݶ����ű�����
	 * @return �����ĵ���VO����
	 */

	public AggArriveorderVO[] sendApprove(AggArriveorderVO[] clientBills,
			AggArriveorderVO[] originBills) {
		for (AggArriveorderVO clientFullVO : clientBills) {
			clientFullVO.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.COMMIT.value());
			clientFullVO.getParentVO().setStatus(VOStatus.UPDATED);
		}
		// ���ݳ־û�
		AggArriveorderVO[] returnVos = new BillUpdate<AggArriveorderVO>().update(
				clientBills, originBills);
		return returnVos;
	}
}
