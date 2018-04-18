package nc.vo.train;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggArriveorderVOMeta extends AbstractBillMeta{
	
	public AggArriveorderVOMeta(){
		this.init();
	}
	
	private void init() {
		this.setParent(nc.vo.train.ArriveorderVO.class);
		this.addChildren(nc.vo.train.ArriveorderBVO.class);
	}
}