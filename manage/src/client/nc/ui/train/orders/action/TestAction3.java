package nc.ui.train.orders.action;

import java.awt.event.ActionEvent;

import nc.bs.pub.pf.PfUtilTools;
import nc.funcnode.ui.FuncletInitData;
import nc.ui.pub.msg.PfLinkData;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ToftPanelAdaptor;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.train.AggOrderVO;

public class TestAction3 extends NCAction {

	private BillManageModel model;

	public TestAction3() {
		this.setCode("testAction3");
		this.setBtnName("��͸���ݵ�TR05");
	}

	/**
	 * ��͸�����������ε��ݹ�����Ϊ��
	 * 1.��ȡ��ǰ��������
	 * 2.ת�����ݣ������ദ��
	 * 3.�����ε��ݽڵ㲢��������
	 */
	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		// MessageDialog.showOkCancelDlg(null, "���԰�ť����", "���ǲ��԰�ť3");
		// AggArriveorderVO
		AggOrderVO aggvo = (AggOrderVO) this.getModel().getSelectedData();
		if (aggvo == null) {
			ExceptionUtils.wrappBusinessException("��ѡ����Ч��������");
		}
		//����PfUtilTools�������ݷ��룬���������յ���ת������
		AggregatedValueObject runChangeData = PfUtilTools.runChangeData("TR04",
				"TR05", aggvo);
		// ���淴������ ���촫������
		PfLinkData linkData = new PfLinkData();
		linkData.setSourceBillID(aggvo.getParentVO().getPk_order());
		linkData.setSourceBillType("TR04");
		linkData.setSourcePkOrg(aggvo.getParentVO().getPk_org());
		linkData.setBillType("TR05");
		linkData.setPkOrg(aggvo.getParentVO().getPk_org());
		linkData.setUserObject(runChangeData);// ��Ҫ���������
		ToftPanelAdaptor adaptor = (ToftPanelAdaptor) getModel().getContext()
				.getEntranceUI();// ��ǰUI�ؼ�
		FuncletInitData initdata = new FuncletInitData();
		initdata.setInitData(linkData);
		initdata.setInitType(nc.ui.pub.linkoperate.ILinkType.LINK_TYPE_ADD);
		// ���ù�����
		//����2=���ε��ݵĹ��ܽڵ��
		//����3=�����ݵ�����
		nc.ui.uap.sf.SFClientUtil2.openFuncNodeFrame(adaptor, "TR010302",
				initdata, null, true);

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
