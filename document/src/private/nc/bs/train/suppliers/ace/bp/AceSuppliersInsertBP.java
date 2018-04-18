package nc.bs.train.suppliers.ace.bp;

import nc.bs.train.suppliers.plugin.bpplugin.SuppliersPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.InsertBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggSupplierVO;

/**
 * ��׼��������BP
 */
public class AceSuppliersInsertBP {

	public AggSupplierVO[] insert(AggSupplierVO[] bills) {

		InsertBPTemplate<AggSupplierVO> bp = new InsertBPTemplate<AggSupplierVO>(
				SuppliersPluginPoint.INSERT);
		this.addBeforeRule(bp.getAroundProcesser());
		this.addAfterRule(bp.getAroundProcesser());
		return bp.insert(bills);

	}

	/**
	 * ���������
	 * 
	 * @param processor
	 */
	private void addAfterRule(AroundProcesser<AggSupplierVO> processor) {
		// TODO ���������
		IRule<AggSupplierVO> rule = null;
	}

	/**
	 * ����ǰ����
	 * 
	 * @param processor
	 */
	private void addBeforeRule(AroundProcesser<AggSupplierVO> processer) {
		// TODO ����ǰ����
		IRule<AggSupplierVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillInsertDataRule();
		processer.addBeforeRule(rule);
	}
}
