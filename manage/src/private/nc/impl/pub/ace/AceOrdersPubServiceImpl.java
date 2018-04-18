package nc.impl.pub.ace;

import nc.bs.train.orders.ace.bp.AceOrdersApproveBP;
import nc.bs.train.orders.ace.bp.AceOrdersDeleteBP;
import nc.bs.train.orders.ace.bp.AceOrdersInsertBP;
import nc.bs.train.orders.ace.bp.AceOrdersSendApproveBP;
import nc.bs.train.orders.ace.bp.AceOrdersUnApproveBP;
import nc.bs.train.orders.ace.bp.AceOrdersUnSendApproveBP;
import nc.bs.train.orders.ace.bp.AceOrdersUpdateBP;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.impl.pubapp.pattern.data.bill.SchemeBillQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.train.AggOrderVO;

public abstract class AceOrdersPubServiceImpl {
	// ����
	public AggOrderVO[] pubinsertBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// ���ݿ������ݺ�ǰ̨���ݹ����Ĳ���VO�ϲ���Ľ��
			BillTransferTool<AggOrderVO> transferTool = new BillTransferTool<AggOrderVO>(
					clientFullVOs);
			// ����BP
			AceOrdersInsertBP action = new AceOrdersInsertBP();
			AggOrderVO[] retvos = action.insert(clientFullVOs);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ɾ��
	public void pubdeleteBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// ����BP
			new AceOrdersDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// �޸�
	public AggOrderVO[] pubupdateBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggOrderVO> transferTool = new BillTransferTool<AggOrderVO>(
					clientFullVOs);
			AceOrdersUpdateBP bp = new AceOrdersUpdateBP();
			AggOrderVO[] retvos = bp.update(clientFullVOs, originBills);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	public AggOrderVO[] pubquerybills(IQueryScheme queryScheme)
			throws BusinessException {
		AggOrderVO[] bills = null;
		try {
			this.preQuery(queryScheme);
			BillLazyQuery<AggOrderVO> query = new BillLazyQuery<AggOrderVO>(
					AggOrderVO.class);
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
	public AggOrderVO[] pubsendapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		AceOrdersSendApproveBP bp = new AceOrdersSendApproveBP();
		AggOrderVO[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// �ջ�
	public AggOrderVO[] pubunsendapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		AceOrdersUnSendApproveBP bp = new AceOrdersUnSendApproveBP();
		AggOrderVO[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// ����
	public AggOrderVO[] pubapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceOrdersApproveBP bp = new AceOrdersApproveBP();
		AggOrderVO[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// ����

	public AggOrderVO[] pubunapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceOrdersUnApproveBP bp = new AceOrdersUnApproveBP();
		AggOrderVO[] retvos = bp.unApprove(clientFullVOs, originBills);
		return retvos;
	}

	public AggOrderVO[] queryRef(IQueryScheme queryScheme)
			throws BusinessException {
		// ע�⣺ʹ��ԭ�в�ѯ�ӿڣ�ʹ���������ز�ѯ��ֻ�е�һ�������б�������
		//���鴦��queryschemer ʹ�� ������ nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor
		SchemeBillQuery<AggOrderVO> billQuery = new SchemeBillQuery<AggOrderVO>(
				AggOrderVO.class);
		
		AggOrderVO[] result = billQuery.query(queryScheme, null);
		return result;
	}

}