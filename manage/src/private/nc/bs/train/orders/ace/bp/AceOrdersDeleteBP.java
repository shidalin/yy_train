package nc.bs.train.orders.ace.bp;

import nc.bs.train.orders.plugin.bpplugin.OrdersPluginPoint;
import nc.vo.train.AggOrderVO;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;


/**
 * ��׼����ɾ��BP
 */
public class AceOrdersDeleteBP {

	public void delete(AggOrderVO[] bills) {

		DeleteBPTemplate<AggOrderVO> bp = new DeleteBPTemplate<AggOrderVO>(
				OrdersPluginPoint.DELETE);
		// ����ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ����ִ�к�ҵ�����
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggOrderVO> processer) {
		// TODO ǰ����
		IRule<AggOrderVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillDeleteStatusCheckRule();
		processer.addBeforeRule(rule);
	}

	/**
	 * ɾ����ҵ�����
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggOrderVO> processer) {
		// TODO �����

	}
}
