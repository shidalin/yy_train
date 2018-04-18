package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.pubapp.pub.rule.UncommitStatusCheckRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.train.arriveorder.plugin.bpplugin.ArriveorderPluginPoint;
import nc.vo.train.AggArriveorderVO;
import nc.itf.train.IArriveorderMaintain;

public class N_TR05_UNSAVEBILL extends AbstractPfAction<AggArriveorderVO> {

	@Override
	protected CompareAroundProcesser<AggArriveorderVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggArriveorderVO> processor = new CompareAroundProcesser<AggArriveorderVO>(
				ArriveorderPluginPoint.UNSEND_APPROVE);
		// TODO 在此处添加前后规则
		processor.addBeforeRule(new UncommitStatusCheckRule());

		return processor;
	}

	@Override
	protected AggArriveorderVO[] processBP(Object userObj,
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills) {
		IArriveorderMaintain operator = NCLocator.getInstance().lookup(
				IArriveorderMaintain.class);
		AggArriveorderVO[] bills = null;
		try {
			bills = operator.unsave(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
