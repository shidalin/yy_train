package nc.vo.train;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.train.ArriveorderVO")

public class AggArriveorderVO extends AbstractBill {
	
	  @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggArriveorderVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public ArriveorderVO getParentVO(){
	  	return (ArriveorderVO)this.getParent();
	  }
	  
}