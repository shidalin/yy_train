package nc.impl.train;

import nc.impl.pub.ace.AceSupclassPubServiceImpl;
import nc.itf.train.ISupclassMaintain;
import nc.vo.train.SupclassVO;
import nc.vo.pub.BusinessException;

public class SupclassMaintainImpl extends AceSupclassPubServiceImpl implements ISupclassMaintain {

      @Override
    public void delete(SupclassVO vos) throws BusinessException {
        super.deletetreeinfo(vos);
    }
  
      @Override
    public SupclassVO insert(SupclassVO vos) throws BusinessException {
        return super.inserttreeinfo(vos);
    }
    
      @Override
    public SupclassVO update(SupclassVO vos) throws BusinessException {
        return super.updatetreeinfo(vos);    
    }
  
      @Override
    public SupclassVO[] query(String whereSql)
        throws BusinessException {
        return super.querytreeinfo(whereSql);
    }

  
}
