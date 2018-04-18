package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.bs.train.arriveorder.plugin.bpplugin.ArriveorderPluginPoint;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.itf.train.IArriveorderMaintain;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.train.AggArriveorderVO;

public class N_TR05_PUSH extends AbstractPfAction<AggArriveorderVO> {

	public N_TR05_PUSH() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CompareAroundProcesser<AggArriveorderVO> getCompareAroundProcesserWithRules(
			Object arg0) {
		CompareAroundProcesser<AggArriveorderVO> processor = new CompareAroundProcesser<AggArriveorderVO>(
				ArriveorderPluginPoint.PUSH);
		// TODO 在此处添加审核前后规则
		IRule<AggArriveorderVO> rule = null;
		processor.addBeforeRule(rule);
		return processor;
	}

	/**
	 * 推单后直接保存
	 */
	@Override
	protected AggArriveorderVO[] processBP(Object userObj,
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills) {
		IArriveorderMaintain operator = NCLocator.getInstance().lookup(
				IArriveorderMaintain.class);
		AggArriveorderVO[] bills = null;
		try {
			bills = operator.insert(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
