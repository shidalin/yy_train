package nc.impl.pub.ace;
import nc.bs.train.chatype.ace.bp.AceChatypeBP;
import nc.impl.pubapp.pub.smart.SmartServiceImpl;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.ISuperVO;
import nc.vo.train.ChatypeVO;
import nc.vo.uif2.LoginContext;

public abstract class AceChatypePubServiceImpl extends SmartServiceImpl {
	public ChatypeVO[] pubquerybasedoc(IQueryScheme querySheme)
			throws nc.vo.pub.BusinessException {
		return new AceChatypeBP().queryByQueryScheme(querySheme);
	}
}