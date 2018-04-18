package nc.impl.train;

import nc.impl.pub.ace.AceOrdersPubServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggOrderVO;
import nc.itf.train.IOrdersMaintain;
import nc.vo.pub.BusinessException;

public class OrdersMaintainImpl extends AceOrdersPubServiceImpl
		implements IOrdersMaintain {

	@Override
	public void delete(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		super.pubdeleteBills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] insert(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubinsertBills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] update(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubupdateBills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] query(IQueryScheme queryScheme)
			throws BusinessException {
		return super.pubquerybills(queryScheme);
	}

	@Override
	public AggOrderVO[] save(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] unsave(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubunsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] approve(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] unapprove(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException {
		return super.pubunapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggOrderVO[] queryRef(IQueryScheme queryScheme)
			throws BusinessException {
		// TODO Auto-generated method stub
		return super.queryRef(queryScheme);
	}

}
