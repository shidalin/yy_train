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
	 * ��͸�����������е��ݹ�����Ϊ�� 1.��д�򿪽ڵ���������´����ʼ�����������߼�
	 */
	@Override
	public void initData(FuncletInitData data) {
		// TODO �Զ����ɵķ������
		Object initData = data.getInitData();
		if (data != null && initData != null
				&& initData instanceof ILinkAddData) {
			super.setIsContainBodyItems(true);
			super.linkAddOperate((ILinkAddData) initData);
		}
		super.initData(data);
	}

}
