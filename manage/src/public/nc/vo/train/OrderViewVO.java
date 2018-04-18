package nc.vo.train;

import nc.vo.pubapp.pattern.model.entity.view.AbstractDataView;
import nc.vo.pubapp.pattern.model.meta.entity.view.DataViewMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.view.IDataViewMeta;

public class OrderViewVO extends AbstractDataView {

	public OrderViewVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IDataViewMeta getMetaData() {
		// 关联元数据信息
		return DataViewMetaFactory.getInstance().getBillViewMeta(
				AggOrderVO.class);
	}
	
	

}
