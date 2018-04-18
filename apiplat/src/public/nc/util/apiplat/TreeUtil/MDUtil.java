package nc.util.apiplat.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.md.MDBaseQueryFacade;
import nc.md.model.IBusinessEntity;
import nc.md.model.IComponent;
import nc.md.model.MetaDataException;
import nc.vo.pub.BusinessException;

/**
 * 接口平台元数据信息查询工具类<br/>
 * shidl@yonyou.com<br/>
 * 2018/04/16<br/>
 */
public class MDUtil {
	/**
	 * 查询
	 * 
	 * @param mdCode
	 * @return
	 * @throws MetaDataException
	 */
	public static IBusinessEntity queryMetaOfMDCode(String mdCode)
			throws MetaDataException {
		IComponent component = MDBaseQueryFacade.getInstance()
				.getComponentByName(mdCode.trim());
		return component.getPrimaryBusinessEntity();
	}

	public static HashMap<String, String> queryRefMapByClassID(String classID)
			throws BusinessException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
				.append("	select t3.name key_name, (t5.fullclassname || '_' || t1.name) value_name	");
		stringBuffer.append("	  from md_property t1	");
		stringBuffer.append("	 inner join md_bizitfmap t2	");
		stringBuffer.append("	    on t1.id = t2.classattrid	");
		stringBuffer.append("	 inner join md_property t3	");
		stringBuffer.append("	    on t2.intattrid = t3.id	");
		stringBuffer.append("	 inner join md_class t4	");
		stringBuffer.append("	    on t3.classid = t4.id	");
		stringBuffer.append("	 inner join md_class t5	");
		stringBuffer.append("	    on t2.classid = t5.id	");
		stringBuffer
				.append("	 where t4.fullclassname = 'nc.vo.bd.meta.IBDObject'	");
		stringBuffer.append("	   and t3.name in ('code', 'name')	");
		stringBuffer.append("	   and t2.classid = ?	");
		SQLParameter sqlParameter = new SQLParameter();
		sqlParameter.addParam(classID);
		ArrayList queryResult = (ArrayList) NCLocator
				.getInstance()
				.lookup(IUAPQueryBS.class)
				.executeQuery(stringBuffer.toString(), sqlParameter,
						new ArrayListProcessor());
		if (queryResult != null && queryResult.size() > 0) {
			HashMap<String, String> result = new HashMap<String, String>();
			for (Object arrayParam : queryResult) {
				Object[] array = (Object[]) arrayParam;
				result.put(array[0].toString(), array[1].toString());
			}
			return result;
		}
		return null;
	}
}
