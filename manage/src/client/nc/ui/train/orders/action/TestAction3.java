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
		this.setBtnName("穿透数据到TR05");
	}

	/**
	 * 穿透传递数据上游单据工作分为：
	 * 1.获取当前界面数据
	 * 2.转换数据（工具类处理）
	 * 3.打开下游单据节点并传递数据
	 */
	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		// MessageDialog.showOkCancelDlg(null, "测试按钮标题", "这是测试按钮3");
		// AggArriveorderVO
		AggOrderVO aggvo = (AggOrderVO) this.getModel().getSelectedData();
		if (aggvo == null) {
			ExceptionUtils.wrappBusinessException("请选择有效操作数据");
		}
		//调用PfUtilTools进行数据翻译，翻译规则参照单据转换规则
		AggregatedValueObject runChangeData = PfUtilTools.runChangeData("TR04",
				"TR05", aggvo);
		// 界面反馈处理 构造传输数据
		PfLinkData linkData = new PfLinkData();
		linkData.setSourceBillID(aggvo.getParentVO().getPk_order());
		linkData.setSourceBillType("TR04");
		linkData.setSourcePkOrg(aggvo.getParentVO().getPk_org());
		linkData.setBillType("TR05");
		linkData.setPkOrg(aggvo.getParentVO().getPk_org());
		linkData.setUserObject(runChangeData);// 需要传输的数据
		ToftPanelAdaptor adaptor = (ToftPanelAdaptor) getModel().getContext()
				.getEntranceUI();// 当前UI控件
		FuncletInitData initdata = new FuncletInitData();
		initdata.setInitData(linkData);
		initdata.setInitType(nc.ui.pub.linkoperate.ILinkType.LINK_TYPE_ADD);
		// 调用工具类
		//参数2=下游单据的功能节点号
		//参数3=被传递的数据
		nc.ui.uap.sf.SFClientUtil2.openFuncNodeFrame(adaptor, "TR010302",
				initdata, null, true);

	}

	/**
	 * 复写父类isActionEnable 控制按钮编辑性
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
		// 控制按钮编辑性必须要实现此行代码
		model.addAppEventListener(this);
	}

}
