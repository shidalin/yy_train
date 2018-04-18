package nc.ui.train.suppliers.ace.serviceproxy;

import nc.bs.framework.common.NCLocator;
import nc.itf.train.ISuppliersMaintain;
import nc.ui.pubapp.pub.task.ISingleBillService;
import nc.vo.train.AggSupplierVO;

public class AceSuppliersDeleteProxy implements
		ISingleBillService<AggSupplierVO> {

	public AceSuppliersDeleteProxy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AggSupplierVO operateBill(AggSupplierVO value) throws Exception {
		ISuppliersMaintain operator = NCLocator.getInstance().lookup(
				ISuppliersMaintain.class);
		operator.delete((AggSupplierVO[]) new AggSupplierVO[] { value });
		return value;
	}

}
