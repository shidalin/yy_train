package nc.bs.train.orders.ace.rule;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggOrderVO;

/**
 * 采购订单保存前规则
 * 
 * @author shidalin
 * 
 */
public class SaveBaseBeforeRule implements IRule<AggOrderVO> {

	public SaveBaseBeforeRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(AggOrderVO[] bills) {
		bills[0].getParentVO().setVmemo("保存前规则测试");
	}

}
