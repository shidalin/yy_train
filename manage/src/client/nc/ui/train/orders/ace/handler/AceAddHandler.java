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
		// ��������֯Ĭ��ֵ
		panel.setHeadItem("pk_group", pk_group);
		panel.setHeadItem("pk_org", pk_org);
		// ���õ���״̬������ҵ������Ĭ��ֵ
		panel.setHeadItem("vbillstatus", BillStatusEnum.FREE.value());
		//���õ���ҵ������
		panel.setHeadItem("dbilldate", AppContext.getInstance().getBusiDate());
		// ���õ�������
		String pk_billtypecode = "TR04";
		String pk_billtypeid = "";
		try {
			pk_billtypeid = nc.bs.ra.common.BillTypeQueryUtil
					.getDefaultBillTypeIdByPk_group(pk_group, pk_billtypecode);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ExceptionUtils.wrappBusinessException("���ݿ�û�д˵������ͼ�¼��"
					+ pk_billtypecode, e1);
		}
		panel.setHeadItem("pk_billtypeid", pk_billtypeid);
		// ���õ������ͱ���
		panel.setHeadItem("pk_billtypecode", pk_billtypecode);
	}
}
