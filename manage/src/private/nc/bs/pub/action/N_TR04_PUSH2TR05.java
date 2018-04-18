package nc.bs.pub.action;

import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.vo.train.AggOrderVO;

public class N_TR04_PUSH2TR05 extends AbstractPfAction<AggOrderVO> {

	public N_TR04_PUSH2TR05() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CompareAroundProcesser<AggOrderVO> getCompareAroundProcesserWithRules(
			Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 自定义按钮推单入口脚本
	 */
	@Override
	protected AggOrderVO[] processBP(Object arg0, AggOrderVO[] clientFullVOs,
			AggOrderVO[] originBills) {
		//实际业务中可以在此做数据过滤或数据加工
		return clientFullVOs;
	}

}
