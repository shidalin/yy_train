package nc.vo.train;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggSupplierVOMeta extends AbstractBillMeta{
	
	public AggSupplierVOMeta(){
		this.init();
	}
	
	private void init() {
		this.setParent(nc.vo.train.SupplierVO.class);
		this.addChildren(nc.vo.train.SupplierBVO.class);
	}
}