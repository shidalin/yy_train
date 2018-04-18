package nc.ui.train.arriveorder.ref;

import java.awt.event.ActionEvent;

import nc.ui.pub.pf.PfUtilClient;
import nc.ui.pubapp.uif2app.actions.AbstractReferenceAction;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.view.BillForm;
import nc.ui.uif2.UIState;
import nc.vo.train.AggArriveorderVO;

/**
 * 参照采购订单
 * 
 * @author shidalin
 * 
 */
public class AddFromTR04Action extends AbstractReferenceAction {

	public AddFromTR04Action() {
		this.setBtnName("参照采购订单");
		this.setCode("TR05RefTR04Action");
	}

	private BillForm editor;

	private BillManageModel model;

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// 当前单据类型编码
		PfUtilClient.childButtonClicked(getSourceBillType(), getModel()
				.getContext().getPk_group(), getModel().getContext()
				.getPk_loginUser(), "TR05", getModel().getContext()
				.getEntranceUI(), null, null);
		if (PfUtilClient.isCloseOK()) {
			AggArriveorderVO[] vos = (AggArriveorderVO[]) PfUtilClient
					.getRetVos();
			this.getTransferViewProcessor().processBillTransfer(vos);
		}

	}

	public BillForm getEditor() {
		return this.editor;
	}

	public BillManageModel getModel() {
		return this.model;
	}

	public void setEditor(BillForm editor) {
		this.editor = editor;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		//添加按钮监听
		model.addAppEventListener(this);
	}

	@Override
	protected boolean isActionEnable() {
		return this.model.getUiState() == UIState.NOT_EDIT;
	}
}
