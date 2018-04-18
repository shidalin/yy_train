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
	private SupModelDataManager manageModelDataManager; // 这里调用XXXModelDataManager，因此方法名要与之保持一致。

	/**
	 * 树控件状态
	 */
	public static String TREE_STATUS_CHANGED = "TREE_STATUS_CHANGED";
	public static int TREE_DISABLE = 1;
	public static int TREE_ENABLE = 0;

	public SupClassMedia() {
		super();
	}

	@Override
	public void handleEvent(AppEvent event) {
		if (event.getSource() == getModel()) {// 数据初始化判断
			Object[] treedatas = getTreeModel().getAllDatas();
			if (AppEventConst.MODEL_INITIALIZED.equals(event.getType())
					&& (null == treedatas || treedatas.length <= 0)) {// 只有树数据为空，即未构造时执行，否则死循环
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
			 * lxiaofan 树选择改变事件
			 */
			if (AppEventConst.SELECTION_CHANGED.equals(event.getType())) {
				SupclassVO classVO = (SupclassVO) getTreeModel() // 根据实际情况修改主表VO名
						.getSelectedData();
				String classID = classVO == null ? "" : classVO.getPrimaryKey();

				/**
				 * 这里构建根据树节点相关参数查询管理单据主键的过滤条件
				 */
				String sql = " pk_supclass = '" + classID + "' "; // 这里的SQL用的是主表和树关联时，主表的字段名
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
		/** 新增带出树主键**lxiaofan**2013-01-15**START **/
		/**
		 * 处理方式比较拙劣，待寻求新方法
		 */
		if (event instanceof nc.ui.pubapp.uif2app.event.billform.AddEvent) {
			Object obj = getTreeModel().getSelectedNode().getUserObject();
			if (null != obj && obj instanceof SupclassVO) { // 根据实际情况修改主表VO名
				String treepk = ((SupclassVO) obj).getPrimaryKey(); // 根据实际情况修改主表VO名
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
		//注册监听
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
