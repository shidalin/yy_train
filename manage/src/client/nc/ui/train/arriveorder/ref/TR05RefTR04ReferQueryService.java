package nc.ui.train.arriveorder.ref;

import nc.bs.framework.common.NCLocator;
import nc.itf.train.IOrdersMaintain;
import nc.ui.pubapp.uif2app.query2.model.IRefQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggOrderVO;

/**
 * 来源单据查询服务，实现具体的上游单据查询逻辑
 * 
 * @author shidalin
 * 
 */
public class TR05RefTR04ReferQueryService implements IRefQueryService {

	public TR05RefTR04ReferQueryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object[] queryByQueryScheme(IQueryScheme queryScheme)
			throws Exception {
		// 调用上游单据接口，查询上游单据
		IOrdersMaintain queryService = (IOrdersMaintain) NCLocator
				.getInstance().lookup(IOrdersMaintain.class);
		//改用重写的查询服务，避免懒加载子表数据加载不全的问题
		AggOrderVO[] aggs = queryService.queryRef(queryScheme);
		return aggs;
	}

	@Override
	public Object[] queryByWhereSql(String arg0) throws Exception {
		// 可在此方法进行查询过滤
		return null;
	}
}
