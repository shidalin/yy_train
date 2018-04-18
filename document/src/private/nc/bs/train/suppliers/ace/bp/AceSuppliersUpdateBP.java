package nc.bs.train.suppliers.ace.bp;

import nc.bs.train.suppliers.plugin.bpplugin.SuppliersPluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.UpdateBPTemplate;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.vo.train.AggSupplierVO;

/**
 * �޸ı����BP
 * 
 */
public class AceSuppliersUpdateBP {

	public AggSupplierVO[] update(AggSupplierVO[] bills,
			AggSupplierVO[] originBills) {
		// �����޸�ģ��
		UpdateBPTemplate<AggSupplierVO> bp = new UpdateBPTemplate<AggSupplierVO>(
				SuppliersPluginPoint.UPDATE);
		// ִ��ǰ����
		this.addBeforeRule(bp.getAroundProcesser());
		// ִ�к����
		this.addAfterRule(bp.getAroundProcesser());
		return bp.update(bills, originBills);
	}

	private void addAfterRule(CompareAroundProcesser<AggSupplierVO> processer) {
		// TODO �����
		IRule<AggSupplierVO> rule = null;

	}

	private void addBeforeRule(CompareAroundProcesser<AggSupplierVO> processer) {
		// TODO ǰ����
		IRule<AggSupplierVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.FillUpdateDataRule();
		processer.addBeforeRule(rule);
	}

}
