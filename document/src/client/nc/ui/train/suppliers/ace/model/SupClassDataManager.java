package nc.ui.train.suppliers.ace.model;

import nc.bs.logging.Logger;
import nc.ui.pubapp.uif2app.query2.model.IModelDataManager;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.ui.train.suppliers.ace.serviceproxy.SupClassAppService;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.ui.uif2.model.IAppModelDataManager;

/**
 * ��Ӧ�̷������ݹ�����
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
	 * ��ʼ����Ӧ������
	 */
	@Override
	public void initModel() {
		Object[] classVOs = null;											
		try {		
			//
			classVOs = new SupClassAppService().queryByDataVisibilitySetting(getModel().getContext());										//�������ǰ���XXXClassAppService����˷�����Ҫ��ǰ�汣��һ�¡�
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
