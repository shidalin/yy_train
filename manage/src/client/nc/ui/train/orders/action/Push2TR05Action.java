package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.actions.pflow.ScriptPFlowAction;

public class Push2TR05Action extends ScriptPFlowAction {

	public Push2TR05Action() {
		this.setBtnName("�������ݵ�TR05");
		this.setCode("push2TR05Action");
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.doAction(e);
		// ��ȡ����aggvo
		// AggOrderVO aggvo = (AggOrderVO) this.getModel().getSelectedData();
		// �ֶ��������̽ű��ӿ�,�����ڵ�ǰactionΪNCAction������
		// NCLocator.getInstance().lookup(IPFBusiAction.class)
		// .processAction("PUSH2TR05", "TR04", null, aggvo, null, null);
	}
}
