package nc.vo.train;

import nc.vo.pf.change.ChangeVOAdjustContext;
import nc.vo.pf.change.IChangeVOAdjust;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;

/**
 * 水平产品交货后处理类
 * 
 * @author shidalin
 * 
 */
public class TR05RefTR04VOChange implements IChangeVOAdjust {

	public TR05RefTR04VOChange() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AggregatedValueObject adjustAfterChange(
			AggregatedValueObject srcAgg, AggregatedValueObject destAgg,
			ChangeVOAdjustContext arg2) throws BusinessException {
		// TODO Auto-generated method stub
		return batchAdjustAfterChange(new AggregatedValueObject[] { srcAgg },
				new AggregatedValueObject[] { destAgg }, arg2)[0];
	}

	@Override
	public AggregatedValueObject adjustBeforeChange(
			AggregatedValueObject srcAgg, ChangeVOAdjustContext arg1)
			throws BusinessException {
		// TODO Auto-generated method stub
		return batchAdjustBeforeChange(new AggregatedValueObject[] { srcAgg },
				arg1)[0];
	}

	@Override
	public AggregatedValueObject[] batchAdjustAfterChange(
			AggregatedValueObject[] srcAgg, AggregatedValueObject[] destAgg,
			ChangeVOAdjustContext arg2) throws BusinessException {
		// 交换后处理方法
		// 可对下游单据进行数据加功
		return destAgg;
	}

	@Override
	public AggregatedValueObject[] batchAdjustBeforeChange(
			AggregatedValueObject[] srcAgg, ChangeVOAdjustContext arg1)
			throws BusinessException {
		// 交换前处理方法
		// 可对上游游单据进行数据加功或者数据过滤（建议在查询实现类进行数据过滤）
		return srcAgg;
	}

}
