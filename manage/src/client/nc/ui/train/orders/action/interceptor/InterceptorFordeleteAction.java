package nc.ui.train.orders.action.interceptor;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.actions.ActionInterceptor;

/**
 * 删除按钮拦截器
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
		// 按钮执行出现异常是否往上层抛出
		return true;
	}

	@Override
	public void afterDoActionSuccessed(Action arg0, ActionEvent arg1) {
		// 按钮执行成功的操作

	}

	@Override
	public boolean beforeDoAction(Action arg0, ActionEvent arg1) {
		// 按钮执行之前的逻辑
		MessageDialog.showHintDlg(null, "拦截器表体", "拦截器测试");
		return false;
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

}
