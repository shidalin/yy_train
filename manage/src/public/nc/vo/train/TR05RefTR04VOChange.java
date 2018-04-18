package nc.vo.train;

import nc.vo.pf.change.ChangeVOAdjustContext;
import nc.vo.pf.change.IChangeVOAdjust;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;

/**
 * ˮƽ��Ʒ����������
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
		// ����������
		// �ɶ����ε��ݽ������ݼӹ�
		return destAgg;
	}

	@Override
	public AggregatedValueObject[] batchAdjustBeforeChange(
			AggregatedValueObject[] srcAgg, ChangeVOAdjustContext arg1)
			throws BusinessException {
		// ����ǰ������
		// �ɶ������ε��ݽ������ݼӹ��������ݹ��ˣ������ڲ�ѯʵ����������ݹ��ˣ�
		return srcAgg;
	}

}
