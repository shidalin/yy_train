package nc.impl.train;

import nc.itf.train.IArraiveOrderReportQuery;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.report.ReportQueryConUtil;

import com.ufida.dataset.IContext;
/**
 * ���ݼӹ���ͨ����������̬��ѯ��䣬������ݲ�ѯ�����Ĳ�ͬ��������ͬ�Ĳ�ѯSQL
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
	 * �ж��Ƿ������̬�� �Ƿ���true.
	 * 
	 * @param qryconutil
	 * @return
	 */
	public boolean isDesignState(ReportQueryConUtil qryconutil) {
		// ��ѯ����Ϊ�գ����̬��
		if (qryconutil.isNull()) {
			return true;
		}
		return false;
	}

}
