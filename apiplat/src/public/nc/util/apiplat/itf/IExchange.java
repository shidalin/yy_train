package nc.util.apiplat.itf;

import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.pub.BusinessException;

/**
 * 
 * 接口平台数据转换持久化接口 <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public interface IExchange {
	/**
	 * 根据主表数据加载子表数据
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	ExchangeVO loadExistExchangeVOWithDetail(ExchangeVO exchangeVO)
			throws BusinessException;

	/**
	 * 保存主子表数据
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	String saveBillMapping(ExchangeVO exchangeVO) throws BusinessException;

	/**
	 * 根据外系统编码、外系统单据编码、NC单据类型编码查询数据转换规则数据
	 * 
	 * @param ext_code
	 * @param ext_bill_code
	 * @param nc_bill_Type
	 * @return
	 * @throws BusinessException
	 */
	ExchangeVO queryExchangeVO(String ext_code, String ext_bill_code,
			String nc_bill_Type) throws BusinessException;

	/**
	 * 根据主键查询数据转换规则
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	ExchangeVO saveExchangeVOWithQuery(ExchangeVO exchangeVO)
			throws BusinessException;

	/**
	 * 删除数据
	 * 
	 * @param exchangeVO
	 * @throws BusinessException
	 */
	void deleteExchangeVO(ExchangeVO exchangeVO) throws BusinessException;
}