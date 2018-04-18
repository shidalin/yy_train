package nc.ui.train.orders.ace.handler;

import nc.ui.pubapp.uif2app.event.IAppEventHandler;
import nc.ui.pubapp.uif2app.event.billform.AddEvent;
import nc.vo.pub.BusinessException;
import nc.vo.pub.pf.BillStatusEnum;
import nc.vo.pubapp.AppContext;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.ui.pub.bill.BillCardPanel;

public class AceAddHandler implements IAppEventHandler<AddEvent> {

	@Override
	public void handleAppEvent(AddEvent e) {
		String pk_group = e.getContext().getPk_group();
		String pk_org = e.getContext().getPk_org();
		BillCardPanel panel = e.getBillForm().getBillCardPanel();
		// 设置主组织默认值
		panel.setHeadItem("pk_group", pk_group);
		panel.setHeadItem("pk_org", pk_org);
		// 设置单据状态、单据业务日期默认值
		panel.setHeadItem("vbillstatus", BillStatusEnum.FREE.value());
		//设置单据业务日期
		panel.setHeadItem("dbilldate", AppContext.getInstance().getBusiDate());
		// 设置单据类型
		String pk_billtypecode = "TR04";
		String pk_billtypeid = "";
		try {
			pk_billtypeid = nc.bs.ra.common.BillTypeQueryUtil
					.getDefaultBillTypeIdByPk_group(pk_group, pk_billtypecode);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ExceptionUtils.wrappBusinessException("数据库没有此单据类型记录："
					+ pk_billtypecode, e1);
		}
		panel.setHeadItem("pk_billtypeid", pk_billtypeid);
		// 设置单据类型编码
		panel.setHeadItem("pk_billtypecode", pk_billtypecode);
	}
}
