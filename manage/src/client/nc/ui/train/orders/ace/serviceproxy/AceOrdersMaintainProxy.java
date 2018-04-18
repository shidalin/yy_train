package nc.ui.train.orders.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.train.IOrdersMaintain;
import nc.ui.pubapp.uif2app.query2.model.IQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceOrdersMaintainProxy implements IQueryService {
	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		IOrdersMaintain query = NCLocator.getInstance().lookup(
				IOrdersMaintain.class);
		return query.query(queryScheme);
	}

}