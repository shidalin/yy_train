package nc.itf.train;

import nc.vo.train.SupclassVO;
import nc.vo.pub.BusinessException;

public interface ISupclassMaintain {

	public void delete(SupclassVO vo) throws BusinessException;

	public SupclassVO insert(SupclassVO vo) throws BusinessException;

	public SupclassVO update(SupclassVO vo) throws BusinessException;

	public SupclassVO[] query(String whereSql) throws BusinessException;
}