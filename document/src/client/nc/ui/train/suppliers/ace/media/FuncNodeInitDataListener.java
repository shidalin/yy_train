package nc.ui.train.suppliers.ace.media;

import nc.funcnode.ui.FuncletInitData;
import nc.ui.train.suppliers.ace.model.SupClassDataManager;
import nc.ui.uif2.IFuncNodeInitDataListener;
import nc.ui.uif2.model.HierachicalDataAppModel;

/**
 * @Title: FuncNodeInitDataListener.java
 * @Package gov.ui.mcpub.indicators.left.tree
 * @Description: 打开节点初始化树结构数据
 * @author ylq
 * @date 2014-12-17 下午5:05:11
 * @version Gov 7.0
 */
public class FuncNodeInitDataListener implements IFuncNodeInitDataListener {

  private SupClassDataManager leftTreeDataManager = null;

  private nc.ui.pubapp.uif2app.model.BillManageModel model = null;

  private HierachicalDataAppModel leftTreeModel = null;

  public HierachicalDataAppModel getLeftTreeModel() {
    return leftTreeModel;
  }

  public void setLeftTreeModel(HierachicalDataAppModel leftTreeModel) {
    this.leftTreeModel = leftTreeModel;
  }

  /**
   * 打开节点初始化数据
   */
  @Override
  public void initData(FuncletInitData data) {
    getLeftTreeDataManager().initModel();
  }

  public SupClassDataManager getLeftTreeDataManager() {
    return leftTreeDataManager;
  }

  public void setLeftTreeDataManager(SupClassDataManager leftTreeDataManager) {
    this.leftTreeDataManager = leftTreeDataManager;
  }

  private nc.ui.pubapp.uif2app.model.BillManageModel getModel() {
    return model;
  }

  public void setModel(nc.ui.pubapp.uif2app.model.BillManageModel model) {
    this.model = model;
  }
}
