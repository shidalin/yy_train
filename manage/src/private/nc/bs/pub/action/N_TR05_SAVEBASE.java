package nc.bs.pub.action;

import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

import nc.bs.train.arriveorder.plugin.bpplugin.ArriveorderPluginPoint;
import nc.vo.train.AggArriveorderVO;
import nc.itf.train.IArriveorderMaintain;

public class N_TR05_SAVEBASE extends AbstractPfAction<AggArriveorderVO> {

	@Override
	protected CompareAroundProcesser<AggArriveorderVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggArriveorderVO> processor = null;
		AggArriveorderVO[] clientFullVOs = (AggArriveorderVO[]) this.getVos();
		if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
				.getPrimaryKey())) {
			processor = new CompareAroundProcesser<AggArriveorderVO>(
					ArriveorderPluginPoint.SCRIPT_UPDATE);
		} else {
			processor = new CompareAroundProcesser<AggArriveorderVO>(
					ArriveorderPluginPoint.SCRIPT_INSERT);
		}
		// TODO 在此处添加前后规则
		IRule<AggArriveorderVO> rule = null;

		return processor;
	}

	@Override
	protected AggArriveorderVO[] processBP(Object userObj,
			AggArriveorderVO[] clientFullVOs, AggArriveorderVO[] originBills) {

		AggArriveorderVO[] bills = null;
		try {
			IArriveorderMaintain operator = NCLocator.getInstance()
					.lookup(IArriveorderMaintain.class);
			if (!StringUtil.isEmptyWithTrim(clientFullVOs[0].getParentVO()
					.getPrimaryKey())) {
				bills = operator.update(clientFullVOs, originBills);
			} else {
				bills = operator.insert(clientFullVOs, originBills);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}
}
