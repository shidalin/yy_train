package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.uif2.NCAction;
import nc.ui.pubapp.uif2app.model.BillManageModel;

public class TestAction extends NCAction {

	private BillManageModel model;

	public TestAction() {
		this.setBtnName("测试按钮1");
		this.setCode("testAction");
	}

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		MessageDialog.showOkCancelDlg(null, "测试按钮标题", "这是测试按钮1");
	}

	/**
	 * 复写父类isActionEnable 控制按钮编辑性
	 */
	@Override
	protected boolean isActionEnable() {
		// 获取当前选中数据
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
		// 控制按钮编辑性必须要实现此行代码
		model.addAppEventListener(this);
	}

}
