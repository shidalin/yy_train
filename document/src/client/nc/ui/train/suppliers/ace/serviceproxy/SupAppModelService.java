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
//根据实际情况导入主子表VO		
//根据实际情况导入主子表VO		
//根据实际情况导入主子表VO		

/**
 * 供应商服务类
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
	 * 根据主键查询AGGVO
	 */
	@Override
	public Object[] queryObjectByPks(String[] pks) throws BusinessException {
		if (pks == null || pks.length == 0)
			return null;
		InSqlBatchCaller caller = new InSqlBatchCaller(pks);
		/**
		 * lxiaofan 这里根据传递的树节点的参数查询VO 返回的是Object[]，可以是表头集，也可以是聚合VO集； 以下仅演示，简单处理；
		 * 需要注意的是，这里的返回对象类型需要与config.xml里的卡控件对应类，
		 * 即这里的MaterialBillForm里的synchronizeDataFromModel方法同步；
		 */
		final List<AggSupplierVO[]> result = new ArrayList<AggSupplierVO[]>();
		try {
			caller.execute(new IInSqlBatchCallBack() {

				public Object doWithInSql(String inSql)
						throws BusinessException, SQLException {
					AggSupplierVO[] billvos = (AggSupplierVO[]) HYPubBO_Client
							.queryBillVOByCondition(new String[] { // 根据实际情况修改主子表VO
									AggSupplierVO.class.getName(), // 根据实际情况修改主子表VO
											SupplierVO.class.getName(), // 根据实际情况修改主子表VO
											SupplierBVO.class.getName() // 根据实际情况修改主子表VO
									}, " pk_supplier in " + inSql); // 根据实际情况修改主表主键
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
	 * 根据条件查询供应商主键
	 * 
	 * @param context
	 * @param condition
	 * @return
	 * @throws Exception
	 */

	public Object[] querySups(LoginContext context, String condition)
			throws Exception {
		/**
		 * lxiaofan 查询管理型单据的主键集
		 */
		String sql = "select pk_supplier from tr_supplier where isnull(dr,0) = 0 and "
				+ condition; // 根据实际情况修改SQL
		List<String> pkList = (List<String>) NCLocator.getInstance()
				.lookup(IUAPQueryBS.class)
				.executeQuery(sql, new ColumnListProcessor());
		return pkList == null || pkList.size() == 0 ? null : pkList
				.toArray(new String[0]);
	}

}
