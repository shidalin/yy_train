package nc.itf.train;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggSupplierVO;
import nc.vo.pub.BusinessException;

public interface ISuppliersMaintain {

	public void delete(AggSupplierVO[] vos) throws BusinessException;

	public AggSupplierVO[] insert(AggSupplierVO[] vos) throws BusinessException;

	public AggSupplierVO[] update(AggSupplierVO[] vos) throws BusinessException;

	public AggSupplierVO[] query(IQueryScheme queryScheme)
			throws BusinessException;

}