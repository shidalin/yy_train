package nc.ui.train.orders.action.interceptor;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.actions.ActionInterceptor;

/**
 * ɾ����ť������
 * 
 * @author shidalin
 * 
 */
public class InterceptorFordeleteAction implements ActionInterceptor {

	private BillManageModel model;

	public InterceptorFordeleteAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean afterDoActionFailed(Action arg0, ActionEvent arg1,
			Throwable arg2) {
		// ��ťִ�г����쳣�Ƿ����ϲ��׳�
		return true;
	}

	@Override
	public void afterDoActionSuccessed(Action arg0, ActionEvent arg1) {
		// ��ťִ�гɹ��Ĳ���

	}

	@Override
	public boolean beforeDoAction(Action arg0, ActionEvent arg1) {
		// ��ťִ��֮ǰ���߼�
		MessageDialog.showHintDlg(null, "����������", "����������");
		return false;
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

}
