package nc.ui.train.suppliers.ace.model;

import nc.bs.logging.Logger;
import nc.ui.pubapp.uif2app.query2.model.IModelDataManager;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.train.suppliers.ace.serviceproxy.SupClassAppService;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.ui.uif2.model.IAppModelDataManager;

/**
 * 供应商分类数据管理类
 * 
 * @author shidalin
 * 
 */
public class SupClassDataManager implements IAppModelDataManager,
		IModelDataManager {

	private HierachicalDataAppModel model;

	public SupClassDataManager() {
		super();
	}

	/**
	 * 初始化供应商数据
	 */
	@Override
	public void initModel() {
		Object[] classVOs = null;											
		try {		
			//
			classVOs = new SupClassAppService().queryByDataVisibilitySetting(getModel().getContext());										//这里调用前面的XXXClassAppService，因此方法名要和前面保持一致。
		} catch (Exception e) {											
			Logger.error(e.getMessage(), e);										
		}											
		getModel().initModel(classVOs);											


	}

	@Override
	public void initModelByQueryScheme(IQueryScheme arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	public HierachicalDataAppModel getModel() {
		return model;
	}

	public void setModel(HierachicalDataAppModel model) {
		this.model = model;
	}

}
