package nc.ui.train.supclass.ace.serviceproxy;

import nc.ui.pubapp.uif2app.model.BaseBillModelDataManager;
import nc.vo.pubapp.AppContext;

public class SupclassModelDataManager extends BaseBillModelDataManager {

	@Override
	public void initModel() {
		//�Զ�������
		String pk_group = AppContext.getInstance().getPkGroup();
		String sqlwhere = " and pk_group = '" + pk_group + "' ";
		super.initModelBySqlWhere(sqlwhere);
	}

}
