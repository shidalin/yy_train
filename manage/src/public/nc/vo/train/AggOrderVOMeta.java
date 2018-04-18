package nc.vo.train;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggOrderVOMeta extends AbstractBillMeta{
	
	public AggOrderVOMeta(){
		this.init();
	}
	
	private void init() {
		this.setParent(nc.vo.train.OrderVO.class);
		this.addChildren(nc.vo.train.OrderBVO.class);
	}
}