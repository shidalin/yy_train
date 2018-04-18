package nc.impl.train;

import nc.impl.pub.ace.AceChatypePubServiceImpl;
import nc.impl.pubapp.pub.smart.BatchSaveAction;
import nc.vo.bd.meta.BatchOperateVO;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.train.ChatypeVO;
import nc.itf.train.IChatypeMaintain;

public class ChatypeMaintainImpl extends AceChatypePubServiceImpl
		implements IChatypeMaintain {

	@Override
	public ChatypeVO[] query(IQueryScheme queryScheme) throws BusinessException {
		return super.pubquerybasedoc(queryScheme);
	}

	@Override
	public BatchOperateVO batchSave(BatchOperateVO batchVO) throws BusinessException {
		BatchSaveAction<ChatypeVO> saveAction = new BatchSaveAction<ChatypeVO>();
		BatchOperateVO retData = saveAction.batchSave(batchVO);
		return retData;
	}
}
