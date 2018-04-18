package nc.itf.train;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggArriveorderVO;
import nc.vo.pub.BusinessException;
/**
 * 独立事务方法
 * methodName_RequiresNew
 * @author shidalin
 *
 */
public interface IArriveorderMaintain {

	public void delete(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] insert(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] update(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] query(IQueryScheme queryScheme)
			throws BusinessException;

	public AggArriveorderVO[] save(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] unsave(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] approve(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

	public AggArriveorderVO[] unapprove(AggArriveorderVO[] clientFullVOs,
			AggArriveorderVO[] originBills) throws BusinessException;

}
