package nc.bs.train.orders.ace.bp;

import nc.impl.pubapp.pattern.data.bill.BillUpdate;
import nc.vo.train.AggOrderVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.pf.BillStatusEnum;

/**
 * ��׼���������BP
 */
public class AceOrdersSendApproveBP {
	/**
	 * ������
	 * 
	 * @param vos
	 *            ����VO����
	 * @param script
	 *            ���ݶ����ű�����
	 * @return �����ĵ���VO����
	 */

	public AggOrderVO[] sendApprove(AggOrderVO[] clientBills,
			AggOrderVO[] originBills) {
		for (AggOrderVO clientFullVO : clientBills) {
			clientFullVO.getParentVO().setAttributeValue("${vmObject.billstatus}",
					BillStatusEnum.COMMIT.value());
			clientFullVO.getParentVO().setStatus(VOStatus.UPDATED);
		}
		// ���ݳ־û�
		AggOrderVO[] returnVos = new BillUpdate<AggOrderVO>().update(
				clientBills, originBills);
		return returnVos;
	}
}
