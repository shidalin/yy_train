package nc.impl.pub.ace;

import nc.vo.train.SupclassVO;
import nc.impl.pubapp.pattern.data.vo.VODelete;
import nc.impl.pubapp.pattern.data.vo.VOInsert;
import nc.impl.pubapp.pattern.data.vo.VOQuery;
import nc.impl.pubapp.pattern.data.vo.VOUpdate;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public abstract class AceSupclassPubServiceImpl {

	// 增加方法
	public SupclassVO inserttreeinfo(SupclassVO vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<SupclassVO> processer = new AroundProcesser<SupclassVO>(
					null);
			processer.before(new SupclassVO[] { vo });
			VOInsert<SupclassVO> ins = new VOInsert<SupclassVO>();
			SupclassVO[] superVOs = ins.insert(new SupclassVO[] { vo });
			return superVOs[0];
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	// 删除方法
	public void deletetreeinfo(SupclassVO vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<SupclassVO> processer = new AroundProcesser<SupclassVO>(
					null);
			processer.before(new SupclassVO[] { vo });
			VODelete<SupclassVO> voDel = new VODelete<SupclassVO>();
			voDel.delete(new SupclassVO[] { vo });
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}

	}

	// 修改方法
	public SupclassVO updatetreeinfo(SupclassVO vo) throws BusinessException {
		try {
			// 添加BP规则
			AroundProcesser<SupclassVO> processer = new AroundProcesser<SupclassVO>(
					null);
			SupclassVO[] originVOs = this
					.getTreeCardVOs(new SupclassVO[] { vo });
			processer.before(new SupclassVO[] { vo });
			VOUpdate<SupclassVO> upd = new VOUpdate<SupclassVO>();
			SupclassVO[] superVOs = upd.update(new SupclassVO[] { vo },
					originVOs);
			return superVOs[0];
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

	private SupclassVO[] getTreeCardVOs(SupclassVO[] vos) {
		String[] ids = this.getIDS(vos);
		VOQuery<SupclassVO> query = new VOQuery<SupclassVO>(SupclassVO.class);
		return query.query(ids);
	}

	private String[] getIDS(SupclassVO[] vos) {
		int size = vos.length;
		String[] ids = new String[size];
		for (int i = 0; i < size; i++) {
			ids[i] = vos[i].getPrimaryKey();
		}
		return ids;
	}

	// 查询方法
	public SupclassVO[] querytreeinfo(String whereSql) throws BusinessException {
		VOQuery<SupclassVO> query = new VOQuery<SupclassVO>(SupclassVO.class);
		return query.query(whereSql, null);
	}
}