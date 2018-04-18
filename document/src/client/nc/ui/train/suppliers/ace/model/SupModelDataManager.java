package nc.ui.train.suppliers.ace.model;

import nc.bs.logging.Logger;
import nc.ui.train.suppliers.ace.serviceproxy.SupAppModelService;
import nc.ui.uif2.components.pagination.BillManagePaginationDelegator;
import nc.ui.uif2.components.pagination.IPaginationModelListener;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.IAppModelDataManagerEx;
import nc.ui.uif2.model.IQueryAndRefreshManager;

import org.apache.commons.lang.StringUtils;

/**
 * ��Ӧ�����ݹ�����
 * 
 * @author shidalin
 * 
 */
public class SupModelDataManager implements IAppModelDataManagerEx,
		IQueryAndRefreshManager, IPaginationModelListener {

	private BillManageModel model;

	private PaginationModel paginationModel;

	private BillManagePaginationDelegator delegator;

	public SupModelDataManager() {
		super();
	}

	@Override
	public void onDataReady() {
		// ���ع�Ӧ������
		getDelegator().onDataReady();

	}

	@Override
	public void onStructChanged() {
		// ���ع�Ӧ������
		getDelegator().onDataReady();

	}

	@Override
	public void initModelBySqlWhere(String sqlWhere) {
		try {
			if (StringUtils.isEmpty(sqlWhere)) {
				sqlWhere = "1=1";
			}
			/**
			 * �������������ѯ���������ڵ������Ĺ����͵��ݵ���������
			 */
			String[] pks = (String[]) new SupAppModelService() // �������XXXAppModelService����˷�����Ҫ��֮����һ�¡�
					.querySups(getModel().getContext(), sqlWhere);
			/**							
			 * 							
			 */
			getPaginationModel().setObjectPks(pks);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initModel() {
		this.initModelBySqlWhere(null);

	}

	@Override
	public void setShowSealDataFlag(boolean arg0) {
		// TODO Auto-generated method stub

	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
	}

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
		// ��Ӽ���
		this.paginationModel.addPaginationModelListener(this);
	}

	public BillManagePaginationDelegator getDelegator() {
		if (this.delegator == null) {
			this.delegator = new BillManagePaginationDelegator(getModel(),
					getPaginationModel());
		}
		return delegator;
	}

	public void setDelegator(BillManagePaginationDelegator delegator) {
		this.delegator = delegator;
	}

}
