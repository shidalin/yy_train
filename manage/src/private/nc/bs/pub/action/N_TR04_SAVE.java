package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.CommitStatusCheckRule;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.train.orders.plugin.bpplugin.OrdersPluginPoint;
import nc.vo.train.AggOrderVO;
import nc.itf.train.IOrdersMaintain;

public class N_TR04_SAVE extends AbstractPfAction<AggOrderVO> {

	protected CompareAroundProcesser<AggOrderVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggOrderVO> processor = new CompareAroundProcesser<AggOrderVO>(
				OrdersPluginPoint.SEND_APPROVE);
		// TODO 在此处添加审核前后规则
		IRule<AggOrderVO> rule = new CommitStatusCheckRule();
		processor.addBeforeRule(rule);
		return processor;
	}

	@Override
	protected AggOrderVO[] processBP(Object userObj,
			AggOrderVO[] clientFullVOs, AggOrderVO[] originBills) {
		IOrdersMaintain operator = NCLocator.getInstance().lookup(
				IOrdersMaintain.class);
		AggOrderVO[] bills = null;
		try {
			bills = operator.save(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
