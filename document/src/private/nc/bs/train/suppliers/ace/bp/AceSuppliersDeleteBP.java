package nc.bs.train.suppliers.ace.bp;

import nc.bs.train.suppliers.plugin.bpplugin.SuppliersPluginPoint;
import nc.vo.train.AggSupplierVO;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;

/**
 * 标准单据删除BP
 */
public class AceSuppliersDeleteBP {

	public void delete(AggSupplierVO[] bills) {

		DeleteBPTemplate<AggSupplierVO> bp = new DeleteBPTemplate<AggSupplierVO>(
				SuppliersPluginPoint.DELETE);
		// 增加执行前规则
		this.addBeforeRule(bp.getAroundProcesser());
		// 增加执行后业务规则
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggSupplierVO> processer) {
		// TODO 前规则
	}

	/**
	 * 删除后业务规则
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggSupplierVO> processer) {
		// TODO 后规则

	}
}
