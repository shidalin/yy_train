package nc.impl.pub.ace;

import nc.bs.train.arriveorder.ace.bp.AceArriveorderInsertBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderUpdateBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderDeleteBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderSendApproveBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderUnSendApproveBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderApproveBP;
import nc.bs.train.arriveorder.ace.bp.AceArriveorderUnApproveBP;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggArriveorderVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public abstract class AceArriveorderPubServiceImpl {
	// ����
	public AggArriveorderVO[] pubinsertBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// ���ݿ������ݺ�ǰ̨���ݹ����Ĳ���VO�ϲ���Ľ��
			BillTransferTool<AggArriveorderVO> transferTool = new BillTransferTool<AggArriveorderVO>(
					clientFullVOs);
			// ����BP
			AceArriveorderInsertBP action = new AceArriveorderInsertBP();
			AggArriveorderVO[] retvos = action.insert(clientFullVOs);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ɾ��
	public void pubdeleteBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// ����BP
			new AceArriveorderDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// �޸�
	public AggArriveorderVO[] pubupdateBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggArriveorderVO> transferTool = new BillTransferTool<AggArriveorderVO>(
					clientFullVOs);
			AceArriveorderUpdateBP bp = new AceArriveorderUpdateBP();
			AggArriveorderVO[] retvos = bp.update(clientFullVOs, originBills);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	public AggArriveorderVO[] pubquerybills(IQueryScheme queryScheme)
			throws BusinessException {
		AggArriveorderVO[] bills = null;
		try {
			this.preQuery(queryScheme);
			BillLazyQuery<AggArriveorderVO> query = new BillLazyQuery<AggArriveorderVO>(
					AggArriveorderVO.class);
			bills = query.query(queryScheme, null);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return bills;
	}

	/**
	 * ������ʵ�֣���ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// ��ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	}

	// �ύ
	public AggArriveorderVO[] pubsendapprovebills(
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills)
			throws BusinessException {
		AceArriveorderSendApproveBP bp = new AceArriveorderSendApproveBP();
		AggArriveorderVO[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// �ջ�
	public AggArriveorderVO[] pubunsendapprovebills(
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills)
			throws BusinessException {
		AceArriveorderUnSendApproveBP bp = new AceArriveorderUnSendApproveBP();
		AggArriveorderVO[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// ����
	public AggArriveorderVO[] pubapprovebills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceArriveorderApproveBP bp = new AceArriveorderApproveBP();
		AggArriveorderVO[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// ����

	public AggArriveorderVO[] pubunapprovebills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceArriveorderUnApproveBP bp = new AceArriveorderUnApproveBP();
		AggArriveorderVO[] retvos = bp.unApprove(clientFullVOs, originBills);
		return retvos;
	}

}