package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.uif2.NCAction;
import nc.ui.pubapp.uif2app.model.BillManageModel;

public class TestAction extends NCAction {

	private BillManageModel model;

	public TestAction() {
		this.setBtnName("���԰�ť1");
		this.setCode("testAction");
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		MessageDialog.showOkCancelDlg(null, "���԰�ť����", "���ǲ��԰�ť1");
	}

	/**
	 * ��д����isActionEnable ���ư�ť�༭��
	 */
	@Override
	protected boolean isActionEnable() {
		// ��ȡ��ǰѡ������
		Object selectedData = this.getModel().getSelectedData();
		if (selectedData == null) {
			return false;
		}
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
