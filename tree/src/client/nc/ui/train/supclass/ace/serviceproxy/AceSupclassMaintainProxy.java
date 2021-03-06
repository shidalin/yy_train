package nc.ui.train.supclass.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.vo.train.SupclassVO;
import nc.itf.train.ISupclassMaintain;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.IBill;
import nc.ui.pubapp.uif2app.model.IQueryService;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.uif2.LoginContext;

/**
 * 示例单据的操作代理
 * 
 * @author author
 * @version tempProject version
 */
public class AceSupclassMaintainProxy implements IAppModelService, IQueryService {
	@Override
	public Object insert(Object object) throws Exception {
		ISupclassMaintain operator = NCLocator.getInstance().lookup(
				ISupclassMaintain.class);
		return operator.insert((SupclassVO) object);
	}

	@Override
	public Object update(Object object) throws Exception {
		ISupclassMaintain operator = NCLocator.getInstance().lookup(
				ISupclassMaintain.class);
		return operator.update((SupclassVO) object);
	}

	@Override
	public void delete(Object object) throws Exception {
		ISupclassMaintain operator = NCLocator.getInstance().lookup(
				ISupclassMaintain.class);
		operator.delete((SupclassVO) object);
	}

	@Override
	public Object[] queryByWhereSql(String whereSql) throws Exception {
		ISupclassMaintain query = NCLocator.getInstance().lookup(
				ISupclassMaintain.class);
		return query.query(whereSql);
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext context)
			throws Exception {
		return null;
	}
}
