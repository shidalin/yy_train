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
 * ��Ӧ�̷��������
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
		// �÷�����ȡ�����ݣ������BDObjectAdpaterFactory�е�createBDObject���������������Ԫ���ݽ��в㼶����
		final List<SupclassVO> result = new ArrayList<SupclassVO>(); // ����ʵ������޸����ӱ�VO������������VO����������AggVO��
		Collection c = NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class)
				.retrieveByClause(SupclassVO.class,
						" isnull(dr,0) = 0 and 1=1 "); // ����ʵ������޸����ӱ�VO������������VO����������AggVO��
		result.addAll(c); // ����ʵ������޸����ӱ�VO������������VO����������AggVO��
		return result.toArray(new SupclassVO[0]);

	}

	@Override
	public Object update(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
