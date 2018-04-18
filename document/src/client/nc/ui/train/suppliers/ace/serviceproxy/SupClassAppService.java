package nc.ui.train.suppliers.ace.serviceproxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.train.SupclassVO;
import nc.vo.uif2.LoginContext;

/**
 * 供应商分类服务类
 * 
 * @author shidalin
 * 
 */
public class SupClassAppService implements IAppModelService {

	public SupClassAppService() {
		super();
	}

	@Override
	public void delete(Object arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object insert(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext arg0)
			throws Exception {
		// 该方法读取树数据，其后在BDObjectAdpaterFactory中的createBDObject方法里根据树所在元数据进行层级构造
		final List<SupclassVO> result = new ArrayList<SupclassVO>(); // 根据实际情况修改主子表VO（这里用主表VO，不是主表AggVO）
		Collection c = NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class)
				.retrieveByClause(SupclassVO.class,
						" isnull(dr,0) = 0 and 1=1 "); // 根据实际情况修改主子表VO（这里用主表VO，不是主表AggVO）
		result.addAll(c); // 根据实际情况修改主子表VO（这里用主表VO，不是主表AggVO）
		return result.toArray(new SupclassVO[0]);

	}

	@Override
	public Object update(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
