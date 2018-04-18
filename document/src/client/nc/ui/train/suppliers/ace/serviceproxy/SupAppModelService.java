package nc.ui.train.suppliers.ace.serviceproxy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnListProcessor;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.uif2.components.pagination.IPaginationQueryService;
import nc.ui.uif2.model.IAppModelService;
import nc.vo.pub.BusinessException;
import nc.vo.trade.sqlutil.IInSqlBatchCallBack;
import nc.vo.trade.sqlutil.InSqlBatchCaller;
import nc.vo.train.AggSupplierVO;
import nc.vo.train.SupplierBVO;
import nc.vo.train.SupplierVO;
import nc.vo.uif2.LoginContext;
//����ʵ������������ӱ�VO		
//����ʵ������������ӱ�VO		
//����ʵ������������ӱ�VO		

/**
 * ��Ӧ�̷�����
 * 
 * @author shidalin
 * 
 */
public class SupAppModelService implements IAppModelService,
		IPaginationQueryService {

	public SupAppModelService() {
		super();
	}

	/**
	 * ����������ѯAGGVO
	 */
	@Override
	public Object[] queryObjectByPks(String[] pks) throws BusinessException {
		if (pks == null || pks.length == 0)
			return null;
		InSqlBatchCaller caller = new InSqlBatchCaller(pks);
		/**
		 * lxiaofan ������ݴ��ݵ����ڵ�Ĳ�����ѯVO ���ص���Object[]�������Ǳ�ͷ����Ҳ�����Ǿۺ�VO���� ���½���ʾ���򵥴���
		 * ��Ҫע����ǣ�����ķ��ض���������Ҫ��config.xml��Ŀ��ؼ���Ӧ�࣬
		 * �������MaterialBillForm���synchronizeDataFromModel����ͬ����
		 */
		final List<AggSupplierVO[]> result = new ArrayList<AggSupplierVO[]>();
		try {
			caller.execute(new IInSqlBatchCallBack() {

				public Object doWithInSql(String inSql)
						throws BusinessException, SQLException {
					AggSupplierVO[] billvos = (AggSupplierVO[]) HYPubBO_Client
							.queryBillVOByCondition(new String[] { // ����ʵ������޸����ӱ�VO
									AggSupplierVO.class.getName(), // ����ʵ������޸����ӱ�VO
											SupplierVO.class.getName(), // ����ʵ������޸����ӱ�VO
											SupplierBVO.class.getName() // ����ʵ������޸����ӱ�VO
									}, " pk_supplier in " + inSql); // ����ʵ������޸���������
					result.add(billvos);
					return null;
				}
			});
		} catch (SQLException e) {
			Logger.error(e.getMessage(), e);
		}

		if (null != result && result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Object insert(Object arg0) throws Exception {
		// return HYPubBO_Client.saveBD((AggSupplierVO)object, null);
		return null;
	}

	@Override
	public Object update(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object arg0) throws Exception {
		// HYPubBO_Client.deleteBD((AggSupplierVO)object, null);
	}

	@Override
	public Object[] queryByDataVisibilitySetting(LoginContext arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����������ѯ��Ӧ������
	 * 
	 * @param context
	 * @param condition
	 * @return
	 * @throws Exception
	 */

	public Object[] querySups(LoginContext context, String condition)
			throws Exception {
		/**
		 * lxiaofan ��ѯ�����͵��ݵ�������
		 */
		String sql = "select pk_supplier from tr_supplier where isnull(dr,0) = 0 and "
				+ condition; // ����ʵ������޸�SQL
		List<String> pkList = (List<String>) NCLocator.getInstance()
				.lookup(IUAPQueryBS.class)
				.executeQuery(sql, new ColumnListProcessor());
		return pkList == null || pkList.size() == 0 ? null : pkList
				.toArray(new String[0]);
	}

}
