package nc.util.apiplat.itf;

import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.pub.BusinessException;

/**
 * 
 * �ӿ�ƽ̨����ת���־û��ӿ� <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public interface IExchange {
	/**
	 * �����������ݼ����ӱ�����
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	ExchangeVO loadExistExchangeVOWithDetail(ExchangeVO exchangeVO)
			throws BusinessException;

	/**
	 * �������ӱ�����
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	String saveBillMapping(ExchangeVO exchangeVO) throws BusinessException;

	/**
	 * ������ϵͳ���롢��ϵͳ���ݱ��롢NC�������ͱ����ѯ����ת����������
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
	 * ����������ѯ����ת������
	 * 
	 * @param exchangeVO
	 * @return
	 * @throws BusinessException
	 */
	ExchangeVO saveExchangeVOWithQuery(ExchangeVO exchangeVO)
			throws BusinessException;

	/**
	 * ɾ������
	 * 
	 * @param exchangeVO
	 * @throws BusinessException
	 */
	void deleteExchangeVO(ExchangeVO exchangeVO) throws BusinessException;
}