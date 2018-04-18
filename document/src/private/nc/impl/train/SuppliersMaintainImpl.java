package nc.impl.train;

import nc.impl.pub.ace.AceSuppliersPubServiceImpl;
import nc.vo.train.AggSupplierVO;
import nc.itf.train.ISuppliersMaintain;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;

public class SuppliersMaintainImpl extends AceSuppliersPubServiceImpl implements
		ISuppliersMaintain {

	@Override
	public void delete(AggSupplierVO[] vos) throws BusinessException {
		super.pubdeleteBills(vos);
	}

	@Override
	public AggSupplierVO[] insert(AggSupplierVO[] vos) throws BusinessException {
		return super.pubinsertBills(vos);
	}

	@Override
	public AggSupplierVO[] update(AggSupplierVO[] vos) throws BusinessException {
		return super.pubupdateBills(vos);
	}

	@Override
	public AggSupplierVO[] query(IQueryScheme queryScheme)
			throws BusinessException {
		return super.pubquerybills(queryScheme);
	}

}
