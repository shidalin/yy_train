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
	// 新增
	public AggArriveorderVO[] pubinsertBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// 数据库中数据和前台传递过来的差异VO合并后的结果
			BillTransferTool<AggArriveorderVO> transferTool = new BillTransferTool<AggArriveorderVO>(
					clientFullVOs);
			// 调用BP
			AceArriveorderInsertBP action = new AceArriveorderInsertBP();
			AggArriveorderVO[] retvos = action.insert(clientFullVOs);
			// 构造返回数据
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除
	public void pubdeleteBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// 调用BP
			new AceArriveorderDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// 修改
	public AggArriveorderVO[] pubupdateBills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		try {
			// 加锁 + 检查ts
			BillTransferTool<AggArriveorderVO> transferTool = new BillTransferTool<AggArriveorderVO>(
					clientFullVOs);
			AceArriveorderUpdateBP bp = new AceArriveorderUpdateBP();
			AggArriveorderVO[] retvos = bp.update(clientFullVOs, originBills);
			// 构造返回数据
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
	 * 由子类实现，查询之前对queryScheme进行加工，加入自己的逻辑
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// 查询之前对queryScheme进行加工，加入自己的逻辑
	}

	// 提交
	public AggArriveorderVO[] pubsendapprovebills(
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills)
			throws BusinessException {
		AceArriveorderSendApproveBP bp = new AceArriveorderSendApproveBP();
		AggArriveorderVO[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// 收回
	public AggArriveorderVO[] pubunsendapprovebills(
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills)
			throws BusinessException {
		AceArriveorderUnSendApproveBP bp = new AceArriveorderUnSendApproveBP();
		AggArriveorderVO[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// 审批
	public AggArriveorderVO[] pubapprovebills(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceArriveorderApproveBP bp = new AceArriveorderApproveBP();
		AggArriveorderVO[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// 弃审

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