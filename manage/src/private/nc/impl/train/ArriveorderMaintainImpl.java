package nc.impl.train;

import nc.impl.pub.ace.AceArriveorderPubServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggArriveorderVO;
import nc.itf.train.IArriveorderMaintain;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.query2.sql.process.QuerySchemeProcessor;

public class ArriveorderMaintainImpl extends AceArriveorderPubServiceImpl
		implements IArriveorderMaintain {

	@Override
	public void delete(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		super.pubdeleteBills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] insert(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubinsertBills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] update(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubupdateBills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] query(IQueryScheme queryScheme)
			throws BusinessException {
		QuerySchemeProcessor querySchemeProcessor = new QuerySchemeProcessor(
				queryScheme);
		String finalFromWhereSql = querySchemeProcessor.getFinalFromWhere();
		return super.pubquerybills(queryScheme);
	}

	@Override
	public AggArriveorderVO[] save(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] unsave(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubunsendapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] approve(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubapprovebills(clientFullVOs, originBills);
	}

	@Override
	public AggArriveorderVO[] unapprove(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException {
		return super.pubunapprovebills(clientFullVOs, originBills);
	}

}
