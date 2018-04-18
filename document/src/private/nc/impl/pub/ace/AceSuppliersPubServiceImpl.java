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
	// ����
	public AggSupplierVO[] pubinsertBills(AggSupplierVO[] vos)
			throws BusinessException {
		try {
			// ���ݿ������ݺ�ǰ̨���ݹ����Ĳ���VO�ϲ���Ľ��
			BillTransferTool<AggSupplierVO> transferTool = new BillTransferTool<AggSupplierVO>(
					vos);
			AggSupplierVO[] mergedVO = transferTool.getClientFullInfoBill();

			// ����BP
			AceSuppliersInsertBP action = new AceSuppliersInsertBP();
			AggSupplierVO[] retvos = action.insert(mergedVO);
			// ���췵������
			return transferTool.getBillForToClient(retvos);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// ɾ��
	public void pubdeleteBills(AggSupplierVO[] vos) throws BusinessException {
		try {
			// ���� �Ƚ�ts
			BillTransferTool<AggSupplierVO> transferTool = new BillTransferTool<AggSupplierVO>(
					vos);
			AggSupplierVO[] fullBills = transferTool.getClientFullInfoBill();
			AceSuppliersDeleteBP deleteBP = new AceSuppliersDeleteBP();
			deleteBP.delete(fullBills);
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

	// �޸�
	public AggSupplierVO[] pubupdateBills(AggSupplierVO[] vos)
			throws BusinessException {
		try {
			// ���� + ���ts
			BillTransferTool<AggSupplierVO> transTool = new BillTransferTool<AggSupplierVO>(
					vos);
			// ��ȫǰ̨VO
			AggSupplierVO[] fullBills = transTool.getClientFullInfoBill();
			// ����޸�ǰvo
			AggSupplierVO[] originBills = transTool.getOriginBills();
			// ����BP
			AceSuppliersUpdateBP bp = new AceSuppliersUpdateBP();
			AggSupplierVO[] retBills = bp.update(fullBills, originBills);
			// ���췵������
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
	 * ������ʵ�֣���ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	 * 
	 * @param queryScheme
	 */
	protected void preQuery(IQueryScheme queryScheme) {
		// ��ѯ֮ǰ��queryScheme���мӹ��������Լ����߼�
	}

}