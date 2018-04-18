package nc.ui.train.arriveorder.ref;

import nc.bs.framework.common.NCLocator;
import nc.itf.train.IOrdersMaintain;
import nc.ui.pubapp.uif2app.query2.model.IRefQueryService;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.train.AggOrderVO;

/**
 * ��Դ���ݲ�ѯ����ʵ�־�������ε��ݲ�ѯ�߼�
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
		// �������ε��ݽӿڣ���ѯ���ε���
		IOrdersMaintain queryService = (IOrdersMaintain) NCLocator
				.getInstance().lookup(IOrdersMaintain.class);
		//������д�Ĳ�ѯ���񣬱����������ӱ����ݼ��ز�ȫ������
		AggOrderVO[] aggs = queryService.queryRef(queryScheme);
		return aggs;
	}

	@Override
	public Object[] queryByWhereSql(String arg0) throws Exception {
		// ���ڴ˷������в�ѯ����
		return null;
	}
}
