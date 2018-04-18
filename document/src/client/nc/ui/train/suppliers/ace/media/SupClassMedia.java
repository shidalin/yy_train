package nc.ui.train.suppliers.ace.media;

import nc.ui.train.suppliers.ace.model.SupModelDataManager;
import nc.ui.uif2.AppEvent;
import nc.ui.uif2.AppEventListener;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.AppEventConst;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.train.SupclassVO;

public class SupClassMedia implements AppEventListener {

	private HierachicalDataAppModel treeModel;
	private BillManageModel model;
	private SupModelDataManager manageModelDataManager; // �������XXXModelDataManager����˷�����Ҫ��֮����һ�¡�

	/**
	 * ���ؼ�״̬
	 */
	public static String TREE_STATUS_CHANGED = "TREE_STATUS_CHANGED";
	public static int TREE_DISABLE = 1;
	public static int TREE_ENABLE = 0;

	public SupClassMedia() {
		super();
	}

	@Override
	public void handleEvent(AppEvent event) {
		if (event.getSource() == getModel()) {// ���ݳ�ʼ���ж�
			Object[] treedatas = getTreeModel().getAllDatas();
			if (AppEventConst.MODEL_INITIALIZED.equals(event.getType())
					&& (null == treedatas || treedatas.length <= 0)) {// ֻ��������Ϊ�գ���δ����ʱִ�У�������ѭ��
				try {
					Object[] data = getTreeModel().getService()
							.queryByDataVisibilitySetting(
									getModel().getContext());
					getTreeModel().initModel(data);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else if (event.getSource() == getTreeModel()) {
			/**
			 * lxiaofan ��ѡ��ı��¼�
			 */
			if (AppEventConst.SELECTION_CHANGED.equals(event.getType())) {
				SupclassVO classVO = (SupclassVO) getTreeModel() // ����ʵ������޸�����VO��
						.getSelectedData();
				String classID = classVO == null ? "" : classVO.getPrimaryKey();

				/**
				 * ���ﹹ���������ڵ���ز�����ѯ�����������Ĺ�������
				 */
				String sql = " pk_supclass = '" + classID + "' "; // �����SQL�õ��������������ʱ��������ֶ���
				/**						
				 */
				getManageModelDataManager().initModelBySqlWhere(sql);
			}
		} else {
			if (AppEventConst.UISTATE_CHANGED.equals(event.getType())) {
				if (getManageModelDataManager().getModel().getUiState() == UIState.EDIT) {
					getTreeModel().fireEvent(
							new AppEvent(TREE_STATUS_CHANGED, getTreeModel(),
									TREE_DISABLE));
				} else {
					getTreeModel().fireEvent(
							new AppEvent(TREE_STATUS_CHANGED, getTreeModel(),
									TREE_ENABLE));
				}
			}
		}
		/** ��������������**lxiaofan**2013-01-15**START **/
		/**
		 * ����ʽ�Ƚ�׾�ӣ���Ѱ���·���
		 */
		if (event instanceof nc.ui.pubapp.uif2app.event.billform.AddEvent) {
			Object obj = getTreeModel().getSelectedNode().getUserObject();
			if (null != obj && obj instanceof SupclassVO) { // ����ʵ������޸�����VO��
				String treepk = ((SupclassVO) obj).getPrimaryKey(); // ����ʵ������޸�����VO��
				nc.ui.pubapp.bill.BillCardPanel cp = (nc.ui.pubapp.bill.BillCardPanel) ((nc.ui.pubapp.uif2app.event.billform.AddEvent) event)
						.getBillForm().getBillCardPanel();
				cp.setHeadItem("pk_supclass", treepk);
			}
		}

	}

	public HierachicalDataAppModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(HierachicalDataAppModel treeModel) {
		this.treeModel = treeModel;
		//ע�����
		this.treeModel.addAppEventListener(this);
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	public SupModelDataManager getManageModelDataManager() {
		return manageModelDataManager;
	}

	public void setManageModelDataManager(
			SupModelDataManager manageModelDataManager) {
		this.manageModelDataManager = manageModelDataManager;
	}

}
