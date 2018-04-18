package nc.itf.train;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggOrderVO;
import nc.vo.pub.BusinessException;

public interface IOrdersMaintain {

	public void delete(AggOrderVO[] clientFullVOs, AggOrderVO[] originBills)
			throws BusinessException;

	public AggOrderVO[] insert(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;

	public AggOrderVO[] update(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;

	public AggOrderVO[] query(IQueryScheme queryScheme)
			throws BusinessException;

	public AggOrderVO[] queryRef(IQueryScheme queryScheme)
			throws BusinessException;

	public AggOrderVO[] save(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;

	public AggOrderVO[] unsave(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;

	public AggOrderVO[] approve(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;

	public AggOrderVO[] unapprove(AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) throws BusinessException;
}
