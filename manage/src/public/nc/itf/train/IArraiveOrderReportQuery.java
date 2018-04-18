package nc.itf.train;

import nc.vo.pub.BusinessException;

import com.ufida.dataset.IContext;

public interface IArraiveOrderReportQuery {

	public String arrriveOrderQuery(IContext context) throws BusinessException;
}
 