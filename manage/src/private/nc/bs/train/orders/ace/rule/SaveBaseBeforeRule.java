package nc.bs.train.orders.ace.rule;

import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggOrderVO;

/**
 * �ɹ���������ǰ����
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
		bills[0].getParentVO().setVmemo("����ǰ�������");
	}

}
