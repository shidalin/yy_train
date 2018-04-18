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
	// 新增
	public AggOrderVO[] pubinsertBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// 数据库中数据和前台传递过来的差异VO合并后的结果
			BillTransferTool<AggOrderVO> transferTool = new BillTransferTool<AggOrderVO>(
					clientFullVOs);
			// 调用BP
			AceOrdersInsertBP action = new AceOrdersInsertBP();
			AggOrderVO[] retvos = action.insert(clientFullVOs);
			// 构造返回数据
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除
	public void pubdeleteBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// 调用BP
			new AceOrdersDeleteBP().delete(clientFullVOs);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// 修改
	public AggOrderVO[] pubupdateBills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		try {
			// 加锁 + 检查ts
			BillTransferTool<AggOrderVO> transferTool = new BillTransferTool<AggOrderVO>(
					clientFullVOs);
			AceOrdersUpdateBP bp = new AceOrdersUpdateBP();
			AggOrderVO[] retvos = bp.update(clientFullVOs, originBills);
			// 构造返回数据
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
	 * 由子类实现，查询之前对queryScheme进行加工，加入自己的逻辑
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// 查询之前对queryScheme进行加工，加入自己的逻辑
	}

	// 提交
	public AggOrderVO[] pubsendapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		AceOrdersSendApproveBP bp = new AceOrdersSendApproveBP();
		AggOrderVO[] retvos = bp.sendApprove(clientFullVOs, originBills);
		return retvos;
	}

	// 收回
	public AggOrderVO[] pubunsendapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		AceOrdersUnSendApproveBP bp = new AceOrdersUnSendApproveBP();
		AggOrderVO[] retvos = bp.unSend(clientFullVOs, originBills);
		return retvos;
	};

	// 审批
	public AggOrderVO[] pubapprovebills(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AceOrdersApproveBP bp = new AceOrdersApproveBP();
		AggOrderVO[] retvos = bp.approve(clientFullVOs, originBills);
		return retvos;
	}

	// 弃审

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
		// 注意：使用原有查询接口，使用了懒加载查询，只有第一条数据有表体数据
		//建议处理queryschemer 使用 工具类 nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor
		SchemeBillQuery<AggOrderVO> billQuery = new SchemeBillQuery<AggOrderVO>(
				AggOrderVO.class);
		
		AggOrderVO[] result = billQuery.query(queryScheme, null);
		return result;
	}

}