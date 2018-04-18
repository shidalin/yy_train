package nc.vo.train;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.train.order.OrderVO")

public class AggOrderVO extends AbstractBill {
	
	  @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggOrderVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public OrderVO getParentVO(){
	  	return (OrderVO)this.getParent();
	  }
	  
}