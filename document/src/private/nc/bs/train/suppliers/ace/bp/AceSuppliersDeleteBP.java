package nc.bs.train.suppliers.ace.bp;

import nc.bs.train.suppliers.plugin.bpplugin.SuppliersPluginPoint;
import nc.vo.train.AggSupplierVO;

import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;

/**
 * ��׼����ɾ��BP
 */
public class AceSuppliersDeleteBP {

	public void delete(AggSupplierVO[] bills) {

		DeleteBPTemplate<AggSupplierVO> bp = new DeleteBPTemplate<AggSupplierVO>(
				SuppliersPluginPoint.DELETE);
		// ����ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ����ִ�к�ҵ�����
		this.addAfterRule(bp.getAroundProcesser());
		bp.delete(bills);
	}

	private void addBeforeRule(AroundProcesser<AggSupplierVO> processer) {
		// TODO ǰ����
	}

	/**
	 * ɾ����ҵ�����
	 * 
	 * @param processer
	 */
	private void addAfterRule(AroundProcesser<AggSupplierVO> processer) {
		// TODO �����

	}
}
