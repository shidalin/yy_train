package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.ApproveStatusCheckRule;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.train.arriveorder.plugin.bpplugin.ArriveorderPluginPoint;
import nc.vo.train.AggArriveorderVO;
import nc.itf.train.IArriveorderMaintain;

public class N_TR05_APPROVE extends AbstractPfAction<AggArriveorderVO> {

	public N_TR05_APPROVE() {
		super();
	}

	@Override
	protected CompareAroundProcesser<AggArriveorderVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggArriveorderVO> processor = new CompareAroundProcesser<AggArriveorderVO>(
				ArriveorderPluginPoint.APPROVE);
		processor.addBeforeRule(new ApproveStatusCheckRule());
		return processor;
	}

	@Override
	protected AggArriveorderVO[] processBP(Object userObj,
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills) {
		AggArriveorderVO[] bills = null;
		IArriveorderMaintain operator = NCLocator.getInstance().lookup(
				IArriveorderMaintain.class);
		try {
			bills = operator.approve(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
