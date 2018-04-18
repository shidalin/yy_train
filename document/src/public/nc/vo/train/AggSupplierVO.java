package nc.vo.train;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;

@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.train.SupplierVO")

public class AggSupplierVO extends AbstractBill {
	
	  @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggSupplierVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public SupplierVO getParentVO(){
	  	return (SupplierVO)this.getParent();
	  }
	  
}