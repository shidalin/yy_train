package nc.itf.train;

import nc.itf.pubapp.pub.smart.ISmartService;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.train.ChatypeVO;

public interface IChatypeMaintain extends ISmartService{

	 public ChatypeVO[] query(IQueryScheme queryScheme)
      throws BusinessException, Exception;
}