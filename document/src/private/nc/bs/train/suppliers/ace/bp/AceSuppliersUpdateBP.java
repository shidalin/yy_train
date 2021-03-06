package nc.bs.train.suppliers.ace.bp;

import nc.bs.train.suppliers.plugin.bpplugin.SuppliersPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggSupplierVO;

/**
 * 修改保存的BP
 * 
 */
public class AceSuppliersUpdateBP {

	public AggSupplierVO[] update(AggSupplierVO[] bills,
			AggSupplierVO[] originBills) {
		// 调用修改模板
		UpdateBPTemplate<AggSupplierVO> bp = new UpdateBPTemplate<AggSupplierVO>(
				SuppliersPluginPoint.UPDATE);
		// 执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 执行后规则
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggSupplierVO> processer) {
		// TODO 后规则
		IRule<AggSupplierVO> rule = null;

	}

	private void addBeforeRule(CompareAroundProcesser<AggSupplierVO> processer) {
		// TODO 前规则
		IRule<AggSupplierVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
	}

}
