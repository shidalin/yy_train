package nc.ui.train.arriveorder.ace.listener;

import nc.funcnode.ui.FuncletInitData;
import nc.ui.pub.linkoperate.ILinkAddData;
import nc.ui.pub.msg.PfLinkData;
import nc.ui.pubapp.billref.dest.TransferViewProcessor;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.vo.train.AggArriveorderVO;

public class ArrveOrderOpenNodeListener extends
		nc.ui.lcm.baselink.listener.DefaultInitDataListener {

	/**
	 * 穿透传递数据下有单据工作分为： 1.复写打开节点监听，重新处理初始化加载数据逻辑
	 */
	@Override
	public void initData(FuncletInitData data) {
		// TODO 自动生成的方法存根
		Object initData = data.getInitData();
		if (data != null && initData != null
				&& initData instanceof ILinkAddData) {
			super.setIsContainBodyItems(true);
			super.linkAddOperate((ILinkAddData) initData);
		}
		super.initData(data);
	}

}
