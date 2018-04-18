package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.ApproveStatusCheckRule;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.train.orders.plugin.bpplugin.OrdersPluginPoint;
import nc.vo.train.AggOrderVO;
import nc.itf.train.IOrdersMaintain;

public class N_TR04_APPROVE extends AbstractPfAction<AggOrderVO> {

	public N_TR04_APPROVE() {
		super();
	}

	@Override
	protected CompareAroundProcesser<AggOrderVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggOrderVO> processor = new CompareAroundProcesser<AggOrderVO>(
				OrdersPluginPoint.APPROVE);
		processor.addBeforeRule(new ApproveStatusCheckRule());
		return processor;
	}

	@Override
	protected AggOrderVO[] processBP(Object userObj,
			AggOrderVO[] clientFullVOs, AggOrderVO[] originBills) {
		AggOrderVO[] bills = null;
		IOrdersMaintain operator = NCLocator.getInstance().lookup(
				IOrdersMaintain.class);
		try {
			bills = operator.approve(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
