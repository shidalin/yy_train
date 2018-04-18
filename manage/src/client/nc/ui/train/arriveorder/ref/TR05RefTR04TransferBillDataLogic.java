package nc.ui.train.arriveorder.ref;

import nc.ui.pubapp.billref.dest.DefaultBillDataLogic;
import nc.vo.pubapp.AppContext;
import nc.vo.train.AggArriveorderVO;

public class TR05RefTR04TransferBillDataLogic extends DefaultBillDataLogic {
	@Override
	public void doTransferAddLogic(Object selectedData) {
		// 1.填充单据类型信息
		if (selectedData != null) {
			AggArriveorderVO agg = (AggArriveorderVO) selectedData;
			agg.getParentVO().setPk_billtypecode("TR05");
			agg.getParentVO().setPk_billtypeid(
					nc.vo.am.common.util.BillTypeUtils.getPKByCode("TR05"));
			agg.getParentVO().setDbilldate(
					AppContext.getInstance().getBusiDate());
		}
		// 把数据设置在界面上
		super.doTransferAddLogic(selectedData);
	}
}
