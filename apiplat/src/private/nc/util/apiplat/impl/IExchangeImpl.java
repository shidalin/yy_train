package nc.util.apiplat.impl;

import java.util.ArrayList;

import nc.bs.dao.BaseDAO;
import nc.bs.ml.NCLangResOnserver;
import nc.bs.uap.lock.PKLock;
import nc.jdbc.framework.SQLParameter;
import nc.util.apiplat.itf.IExchange;
import nc.vo.apiplat.exchange.ExchangeRuleVO;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.util.BDVersionValidationUtil;

/**
 * 
 * �ӿ�ƽ̨����ת���־û��ӿ�ʵ���� <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public class IExchangeImpl implements IExchange {

	@Override
	public ExchangeVO loadExistExchangeVOWithDetail(ExchangeVO currExchangeVO)
			throws BusinessException {
		BaseDAO dao = new BaseDAO();
		SQLParameter param = new SQLParameter();
		param.addParam(currExchangeVO.getPk_apiplat_trans());
		currExchangeVO = (ExchangeVO) dao.retrieveByPK(ExchangeVO.class,
				currExchangeVO.getPk_apiplat_trans());
		ArrayList<ExchangeRuleVO> blist = (ArrayList<ExchangeRuleVO>) dao
				.retrieveByClause(ExchangeRuleVO.class, "pk_apiplat_trans=?",
						param);
		if (blist != null && blist.size() > 0) {
			currExchangeVO.setRuleVOList(blist);
		}
		return currExchangeVO;
	}

	/**
	 * �ӱ���棬
	 */
	@Override
	public String saveBillMapping(ExchangeVO curExchangeVO)
			throws BusinessException {
		if (!StringUtil.isEmptyWithTrim(curExchangeVO.getPrimaryKey())) {
			lockAndValidateVersion(curExchangeVO);
		}
		BaseDAO dao = new BaseDAO();
		// ���������δ���棬���ȱ���֮
		if (StringUtil.isEmptyWithTrim(curExchangeVO.getPrimaryKey())) {
			String pk = dao.insertVO(curExchangeVO);
			curExchangeVO.setPrimaryKey(pk);
		}

		// ��������
		ArrayList<ExchangeRuleVO> alRules = new ArrayList<ExchangeRuleVO>();
		if (curExchangeVO.getRuleVOList() != null
				&& curExchangeVO.getRuleVOList().size() > 0) {
			for (ExchangeRuleVO ruleVO : curExchangeVO.getRuleVOList()) {
				ruleVO.setPk_apiplat_trans(curExchangeVO.getPk_apiplat_trans());
				alRules.add(ruleVO);
			}
		}
		// ��ɾ��������������
		SQLParameter param = new SQLParameter();
		param.addParam(curExchangeVO.getPk_apiplat_trans());
		dao.deleteByClause(ExchangeRuleVO.class, "pk_apiplat_trans=?", param);
		if (alRules.size() > 0) {
			dao.insertVOList(alRules);
		}
		return curExchangeVO.getPrimaryKey();
	}

	private void lockAndValidateVersion(SuperVO vo) throws BusinessException {
		// ������
		boolean locked = PKLock.getInstance()
				.addDynamicLock(vo.getPrimaryKey());
		if (!locked) {
			throw new BusinessException(NCLangResOnserver.getInstance()
					.getStrByID("uif2", "DefaultExceptionHanler-000000")/* ��������������������޸� */);
		}
		BDVersionValidationUtil.validateSuperVO(vo);
	}

	@Override
	public ExchangeVO queryExchangeVO(String ext_code, String ext_bill_code,
			String nc_bill_Type) throws BusinessException {
		BaseDAO dao = new BaseDAO();
		SQLParameter param = new SQLParameter();
		param.addParam(ext_code);
		param.addParam(ext_bill_code);
		param.addParam(nc_bill_Type);
		ArrayList<ExchangeVO> changeVOList = (ArrayList<ExchangeVO>) dao
				.retrieveByClause(ExchangeVO.class,
						"ext_code=? and ext_bill_code=? and nc_bill_Type=?",
						param);
		if (changeVOList == null || changeVOList.size() != 1) {
			return null;
		}
		ExchangeVO exchangeVO = changeVOList.get(0);

		SQLParameter paramb = new SQLParameter();
		paramb.addParam(exchangeVO.getPk_apiplat_trans());

		ArrayList<ExchangeRuleVO> ruleVOList = (ArrayList<ExchangeRuleVO>) dao
				.retrieveByClause(ExchangeRuleVO.class,
						"pk_apiplat_trans=?  and ext_field_code  is not null",
						paramb);
		exchangeVO.setRuleVOList(ruleVOList);
		return exchangeVO;
	}

	@Override
	public ExchangeVO saveExchangeVOWithQuery(ExchangeVO exchangeVO)
			throws BusinessException {
		BaseDAO baseDAO = new BaseDAO();
		String pk = saveExchangeVO(exchangeVO);
		exchangeVO = (ExchangeVO) baseDAO.retrieveByPK(ExchangeVO.class, pk);
		return exchangeVO;
	}

	@Override
	public void deleteExchangeVO(ExchangeVO exchangeVO)
			throws BusinessException {
		BaseDAO baseDAO = new BaseDAO();
		lockAndValidateVersion(exchangeVO);
		baseDAO.deleteVO(exchangeVO);
		// ɾ�ӱ�
		String condition = "pk_apiplat_trans='"
				+ exchangeVO.getPk_apiplat_trans() + "'";
		baseDAO.deleteByClause(ExchangeRuleVO.class, condition);
	}

	/**
	 * ������������
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	public String saveExchangeVO(ExchangeVO exchangeVO)
			throws BusinessException {
		BaseDAO baseDAO = new BaseDAO();
		String Pk_apiplat_trans = exchangeVO.getPk_apiplat_trans();
		if (StringUtil.isEmptyWithTrim(Pk_apiplat_trans)) {
			Pk_apiplat_trans = baseDAO.insertVO(exchangeVO);
		} else {
			// �����ӱ�����
			ExchangeVO sourceExchangeVO = (ExchangeVO) this
					.loadExistExchangeVOWithDetail(exchangeVO);
			// 1.�޸�Ĭ��ת������Ӱ���ӱ�����
			if (!sourceExchangeVO.getDefault_trans_rule().equals(
					exchangeVO.getDefault_trans_rule())) {
				exchangeVO.setRuleVOList(sourceExchangeVO.getRuleVOList());
				for (ExchangeRuleVO bvo : exchangeVO.getRuleVOList()) {
					bvo.setTrans_rule(exchangeVO.getDefault_trans_rule());
				}
				this.saveBillMapping(exchangeVO);
			}
			// 2.�޸�NC��������Ӱ���ӱ�����
			if (!sourceExchangeVO.getNc_bill_type().equals(
					exchangeVO.getNc_bill_type())) {
				exchangeVO.setRuleVOList(null);
				this.saveBillMapping(exchangeVO);
			}
			// ������������
			baseDAO.updateVO(exchangeVO);
		}
		return Pk_apiplat_trans;
	}

}
