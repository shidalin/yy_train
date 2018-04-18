package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.ui.pubapp.uif2app.actions.pflow.ScriptPFlowAction;

public class Push2TR05Action extends ScriptPFlowAction {

	public Push2TR05Action() {
		this.setBtnName("推送数据到TR05");
		this.setCode("push2TR05Action");
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.doAction(e);
		// 获取界面aggvo
		// AggOrderVO aggvo = (AggOrderVO) this.getModel().getSelectedData();
		// 手动调用流程脚本接口,适用于当前action为NCAction的子类
		// NCLocator.getInstance().lookup(IPFBusiAction.class)
		// .processAction("PUSH2TR05", "TR04", null, aggvo, null, null);
	}
}
