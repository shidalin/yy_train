package nc.bs.train.orders.ace.bp;

import nc.bs.train.orders.plugin.bpplugin.OrdersPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggOrderVO;

/**
 * 修改保存的BP
 * 
 */
public class AceOrdersUpdateBP {

	public AggOrderVO[] update(AggOrderVO[] bills,
			AggOrderVO[] originBills) {
		// 调用修改模板
		UpdateBPTemplate<AggOrderVO> bp = new UpdateBPTemplate<AggOrderVO>(
				OrdersPluginPoint.UPDATE);
		// 执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 执行后规则
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggOrderVO> processer) {
		// TODO 后规则
		IRule<AggOrderVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.BillCodeCheckRule();
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule).setCbilltype("TR04");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule)
				.setCodeItem("vbillno");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule)
				.setGroupItem("pk_group");
		((nc.bs.pubapp.pub.rule.BillCodeCheckRule) rule).setOrgItem("pk_org");
		processer.addAfterRule(rule);

	}

	private void addBeforeRule(CompareAroundProcesser<AggOrderVO> processer) {
		// TODO 前规则
		IRule<AggOrderVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
		nc.impl.pubapp.pattern.rule.ICompareRule<AggOrderVO> ruleCom = new nc.bs.pubapp.pub.rule.UpdateBillCodeRule();
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setCbilltype("TR04");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setCodeItem("vbillno");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setGroupItem("pk_group");
		((nc.bs.pubapp.pub.rule.UpdateBillCodeRule) ruleCom)
				.setOrgItem("pk_org");
		processer.addBeforeRule(ruleCom);
	}

}
