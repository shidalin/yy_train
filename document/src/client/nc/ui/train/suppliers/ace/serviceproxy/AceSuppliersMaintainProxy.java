package nc.ui.train.suppliers.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.ui.pubapp.pub.task.ISingleBillService;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.pubapp.uif2app.actions.IDataOperationService;
import nc.ui.pubapp.uif2app.query2.model.IQueryService;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.train.AggSupplierVO;
import nc.itf.train.ISuppliersMaintain;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceSuppliersMaintainProxy implements IDataOperationService,
		IQueryService ,ISingleBillService<AggSupplierVO>{
	@Override
	public IBill[] insert(IBill[] value) throws BusinessException {
		ISuppliersMaintain operator = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		AggSupplierVO[] vos = operator.insert((AggSupplierVO[]) value);
		return vos;
	}

	@Override
	public IBill[] update(IBill[] value) throws BusinessException {
		ISuppliersMaintain operator = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		AggSupplierVO[] vos = operator.update((AggSupplierVO[]) value);
		return vos;
	}

	@Override
	public IBill[] delete(IBill[] value) throws BusinessException {
		// 目前的删除并不是走这个方法，由于pubapp不支持从这个服务中执行删除操作
		// 单据的删除实际上使用的是：ISingleBillService<AggSingleBill>的operateBill
		ISuppliersMaintain operator = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		operator.delete((AggSupplierVO[]) value);
		return value;
	}
	
	@Override
	public AggSupplierVO operateBill(AggSupplierVO bill) throws Exception {
		ISuppliersMaintain operator = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		operator.delete(new AggSupplierVO[] { bill });
		return bill;
	}

	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		ISuppliersMaintain query = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		return query.query(queryScheme);
	}

}
