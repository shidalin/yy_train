package nc.impl.pub.ace;

import nc.bs.train.suppliers.ace.bp.AceSuppliersInsertBP;
import nc.bs.train.suppliers.ace.bp.AceSuppliersUpdateBP;
import nc.bs.train.suppliers.ace.bp.AceSuppliersDeleteBP;
import nc.impl.pubapp.pattern.data.bill.BillLazyQuery;
import nc.impl.pubapp.pattern.data.bill.tool.BillTransferTool;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.train.AggSupplierVO;

public abstract class AceSuppliersPubServiceImpl {
	// 新增
	public AggSupplierVO[] pubinsertBills(AggSupplierVO[] vos)
			throws BusinessException {
		try {
			// 数据库中数据和前台传递过来的差异VO合并后的结果
			BillTransferTool<AggSupplierVO> transferTool = new BillTransferTool<AggSupplierVO>(
					vos);
			AggSupplierVO[] mergedVO = transferTool.getClientFullInfoBill();

			// 调用BP
			AceSuppliersInsertBP action = new AceSuppliersInsertBP();
			AggSupplierVO[] retvos = action.insert(mergedVO);
			// 构造返回数据
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除
	public void pubdeleteBills(AggSupplierVO[] vos) throws BusinessException {
		try {
			// 加锁 比较ts
			BillTransferTool<AggSupplierVO> transferTool = new BillTransferTool<AggSupplierVO>(
					vos);
			AggSupplierVO[] fullBills = transferTool.getClientFullInfoBill();
			AceSuppliersDeleteBP deleteBP = new AceSuppliersDeleteBP();
			deleteBP.delete(fullBills);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// 修改
	public AggSupplierVO[] pubupdateBills(AggSupplierVO[] vos)
			throws BusinessException {
		try {
			// 加锁 + 检查ts
			BillTransferTool<AggSupplierVO> transTool = new BillTransferTool<AggSupplierVO>(
					vos);
			// 补全前台VO
			AggSupplierVO[] fullBills = transTool.getClientFullInfoBill();
			// 获得修改前vo
			AggSupplierVO[] originBills = transTool.getOriginBills();
			// 调用BP
			AceSuppliersUpdateBP bp = new AceSuppliersUpdateBP();
			AggSupplierVO[] retBills = bp.update(fullBills, originBills);
			// 构造返回数据
			retBills = transTool.getBillForToClient(retBills);
			return retBills;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	public AggSupplierVO[] pubquerybills(IQueryScheme queryScheme)
			throws BusinessException {
		AggSupplierVO[] bills = null;
		try {
			this.preQuery(queryScheme);
			BillLazyQuery<AggSupplierVO> query = new BillLazyQuery<AggSupplierVO>(
					AggSupplierVO.class);
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

}