package nc.ui.train.arriveorder.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.train.IArriveorderMaintain;
import nc.ui.pubapp.uif2app.query2.model.IQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceArriveorderMaintainProxy implements IQueryService {
	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		IArriveorderMaintain query = NCLocator.getInstance().lookup(
				IArriveorderMaintain.class);
		return query.query(queryScheme);
	}

}