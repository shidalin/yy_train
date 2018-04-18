package nc.impl.train;

import nc.itf.train.IArraiveOrderReportQuery;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.report.ReportQueryConUtil;

import com.ufida.dataset.IContext;
/**
 * 数据加功：通常用来处理动态查询语句，比如根据查询条件的不同，构建不同的查询SQL
 * @author shidalin
 *
 */
public class ArraiveOrderReportQueryImpl implements IArraiveOrderReportQuery {

	@Override
	public String arrriveOrderQuery(IContext context) throws BusinessException {
		ReportQueryConUtil qryconutil = new ReportQueryConUtil(context);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("	SELECT t1.*, t2.*	");
		stringBuffer.append("	  FROM tr_order t1	");
		stringBuffer.append("	 INNER JOIN tr_order_b t2	");
		stringBuffer.append("	    ON t1.pk_order = t2.pk_order	");
		stringBuffer.append("	 INNER JOIN tr_arriveorder_b t3	");
		stringBuffer.append("	    ON t3.csourcebid = t2.pk_order_b	");
		stringBuffer.append("	 INNER JOIN tr_arriveorder t4	");
		stringBuffer.append("	    ON t3.pk_arrive = t4.pk_arrive	");
		stringBuffer.append("	 WHERE nvl(t1.dr, 0) = 0	");
		stringBuffer.append("	   AND nvl(t2.dr, 0) = 0	");
		stringBuffer.append("	   AND nvl(t3.dr, 0) = 0	");
		stringBuffer.append("	   AND nvl(t4.dr, 0) = 0	");
		String querySql = stringBuffer.toString();
		return null;
	}

	/**
	 * 判断是否是设计态。 是返回true.
	 * 
	 * @param qryconutil
	 * @return
	 */
	public boolean isDesignState(ReportQueryConUtil qryconutil) {
		// 查询条件为空，设计态。
		if (qryconutil.isNull()) {
			return true;
		}
		return false;
	}

}
