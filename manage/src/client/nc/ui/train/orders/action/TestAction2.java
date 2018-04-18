package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;

public class TestAction2 extends NCAction {

	private BillManageModel model;

	public TestAction2() {
		this.setCode("testAction2");
		this.setBtnName("���԰�ť2");
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		MessageDialog.showOkCancelDlg(null, "���԰�ť����", "���ǲ��԰�ť2");
	}

	/**
	 * ��д����isActionEnable ���ư�ť�༭��
	 */
	@Override
	protected boolean isActionEnable() {
		return true;
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		// ���ư�ť�༭�Ա���Ҫʵ�ִ��д���
		model.addAppEventListener(this);
	}

}
