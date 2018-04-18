package nc.util.apiplat.TreeUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.lightapp.base.database.SqlParameter;
import nc.util.apiplat.itf.IExchange;
import nc.vo.apiplat.exchange.ExchangeRuleVO;
import nc.vo.apiplat.exchange.ExchangeVO;
import nc.vo.apiplat.exchange.TransStyleEnum;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;

import org.dom4j.DocumentException;
import org.mozilla.javascript.edu.emory.mathcs.backport.java.util.Collections;

import com.alibaba.fastjson.JSONArray;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 
 * �ӿ�ƽ̨��������ת�������� <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public class PubExchangeUtil {

	public ArrayList<String> tansFormat(String ext_code, String ext_bill_code,
			String nc_bill_Type, ArrayList sourceList)
			throws BusinessException, DocumentException, IOException,
			ClassNotFoundException {
		ArrayList<String> result = new ArrayList<String>();
		if (sourceList == null || sourceList.size() == 0) {
			throw new BusinessException("�봫����ȷԴͷ����");
		}
		// ��ѯ��ϵͳ�ֶηǿյ�ת������
		ExchangeVO exchangeVO = NCLocator.getInstance().lookup(IExchange.class)
				.queryExchangeVO(ext_code, ext_bill_code, nc_bill_Type);
		this.exchangeVO = exchangeVO;
		if (TransStyleEnum.json_style.toInt() == Integer
				.parseInt(this.exchangeVO.getTrans_style())) {
			for (Object obj : sourceList) {
				this.currentSourceVO = obj;
				this.process(ext_code, ext_bill_code, nc_bill_Type);
				String trans2Json = this.trans2Json();
				result.add(trans2Json);
			}
		} else if (TransStyleEnum.xml_style.toInt() == Integer
				.parseInt(this.exchangeVO.getTrans_style())) {
			for (Object obj : sourceList) {
				this.currentSourceVO = obj;
				this.process(ext_code, ext_bill_code, nc_bill_Type);
				String trans2Xml = this.trans2Xml();
				result.add(trans2Xml);
			}
		}
		return result;
	};

	/**
	 * ����ת����ȡJSON��ʽ����
	 * 
	 * @param ext_code
	 * @param ext_bill_code
	 * @param nc_bill_Type
	 * @return
	 * @throws BusinessException
	 */
	private String trans2Json() throws BusinessException {
		// ת�� JSON ��ʽ
		String jsonString = JSONArray.toJSONString(this.formatMap);
		return jsonString;

	}

	/**
	 * ����ת����ȡXML��ʽ����
	 * 
	 * @param ext_code
	 * @param ext_bill_code
	 * @param nc_bill_Type
	 * @return
	 * @throws BusinessException
	 * @throws DocumentException
	 * @throws IOException
	 */
	private String trans2Xml() throws BusinessException, DocumentException,
			IOException {
		// ת��XML��ʽ
		String xmlString = nc.util.apiplat.TreeUtil.XmlUtil
				.formatXml(nc.util.apiplat.TreeUtil.XmlUtil
						.map2xml(this.formatMap));
		return xmlString;
	}

	/**
	 * 
	 * @param ext_code
	 *            ��ϵͳ����
	 * @param ext_bill_code
	 *            ��ϵͳ���ݱ���
	 * @param nc_bill_Type
	 *            NCϵͳ�������ͱ���
	 * @throws BusinessException
	 * @throws ClassNotFoundException
	 */
	private void process(String ext_code, String ext_bill_code,
			String nc_bill_Type) throws BusinessException,
			ClassNotFoundException {
		ArrayList<ExchangeRuleVO> ruleVOList = this.exchangeVO.getRuleVOList();
		if (exchangeVO == null || ruleVOList == null || ruleVOList.size() == 0) {
			throw new BusinessException("�ӿ�ƽ̨���ݽ������򲻴��ڻ����ô���");
		}
		ArrayList<TreeEntity> childList = new ArrayList<TreeEntity>();
		ArrayList<TreeEntity> rootList = new ArrayList<TreeEntity>();
		ArrayList<String> rootIdList = new ArrayList<String>();
		ArrayList<String> childIdList = new ArrayList<String>();
		// ���㼶���򣬷����ڹ���MAP����
		sortByExtFieldCode(ruleVOList);
		constructTreeNode(ruleVOList, childList, rootList, rootIdList,
				childIdList);
		if (rootList.size() > 0) {
			TreeUtil treeUtil = new TreeUtil();
			for (TreeEntity root : rootList) {
				root = treeUtil.getTreeList(root, childList);
				iteratorTree(root, null);
			}
		}
	}

	/**
	 * �������ݿ��ַ����������ڵ�
	 * 
	 * @param ruleVOList
	 * @param childList
	 * @param rootList
	 * @param rootIdList
	 * @param childIdList
	 */
	private void constructTreeNode(ArrayList<ExchangeRuleVO> ruleVOList,
			ArrayList<TreeEntity> childList, ArrayList<TreeEntity> rootList,
			ArrayList<String> rootIdList, ArrayList<String> childIdList) {
		for (ExchangeRuleVO bvo : ruleVOList) {
			String ext_field_code = bvo.getExt_field_code();
			String nc_field_code = bvo.getNc_field_code();
			// ����ֶν��в��,����tree
			if (ext_field_code.contains(".")) {
				String rootId = ext_field_code.substring(0,
						ext_field_code.indexOf("."));
				if (!rootIdList.contains(rootId)) {
					TreeEntity root = new TreeEntity();
					root.setId(rootId);
					root.setCode(rootId);
					root.setSourceData(bvo);
					rootIdList.add(rootId);
					rootList.add(root);
				}
				while (ext_field_code.contains(".")) {
					String fatherId = ext_field_code.substring(0,
							ext_field_code.lastIndexOf("."));
					if (!childIdList.contains(ext_field_code)) {
						String code = ext_field_code.substring(
								ext_field_code.lastIndexOf(".") + 1,
								ext_field_code.length());
						TreeEntity treeEntity = new TreeEntity();
						treeEntity.setFatherId(fatherId);
						treeEntity.setId(ext_field_code);
						treeEntity.setCode(code);
						treeEntity.setValue(nc_field_code);
						treeEntity.setSourceData(bvo);
						childIdList.add(ext_field_code);
						childList.add(treeEntity);

					}
					ext_field_code = fatherId;

				}
			}
		}
	}

	private Map formatMap = new HashMap();

	private Object currentSourceVO = null;

	private ExchangeVO exchangeVO;

	/**
	 * ������,�������
	 * 
	 * @param tree
	 * @throws BusinessException
	 * @throws ClassNotFoundException
	 */
	private void iteratorTree(TreeEntity tree, HashMap parentMap)
			throws BusinessException, ClassNotFoundException {
		if (!tree.isIsleaf()) {
			ArrayList<Object> arrayList = new ArrayList<>();
			if (parentMap != null) {
				parentMap.put(tree.getCode(), arrayList);
			}
			for (TreeEntity ctree : tree.getChildList()) {
				HashMap<Object, Object> hashMap = new HashMap<>();
				if (ctree.isIsleaf()) {
					// ����ȡֵ
					ctree = fillDataFromSourceData(ctree);
					// ��������
					hashMap.put(ctree.getCode(), ctree.getValue());
				} else {
					iteratorTree(ctree, hashMap);
				}
				arrayList.add(hashMap);
			}
			if (!tree.getId().contains(".")) {
				// root�ڵ�Ž������map
				formatMap.put(tree.getCode(), arrayList);
			}
		} else if (tree.getLevel() == 1) {
			// root�ڵ�Ž������map
			formatMap.put(tree.getCode(), tree.getValue());
		}
	}

	/**
	 * ����ת�������ȡת������
	 * 
	 * @param ctree
	 * @return
	 * @throws BusinessException
	 * @throws ClassNotFoundException
	 */
	private TreeEntity fillDataFromSourceData(TreeEntity ctree)
			throws BusinessException, ClassNotFoundException {
		IUAPQueryBS uapQueryBS = NCLocator.getInstance().lookup(
				IUAPQueryBS.class);
		String fieldKey = ctree.getValue();
		String nc_field_code = ctree.getSourceData().getNc_field_code();
		String sourceValue = "";
		// ����ģ��
		if (this.currentSourceVO instanceof SuperVO) {
			Object attributeValue = ((SuperVO) this.currentSourceVO)
					.getAttributeValue(nc_field_code);
			sourceValue = attributeValue == null ? "" : attributeValue
					.toString();
		}
		// ��ʱֻ�������ӱ�ģ��
		if (this.currentSourceVO instanceof AggregatedValueObject) {
			CircularlyAccessibleValueObject parentVO = ((AggregatedValueObject) this.currentSourceVO)
					.getParentVO();
			CircularlyAccessibleValueObject[] childrenVOs = ((AggregatedValueObject) this.currentSourceVO)
					.getChildrenVO();
			if (nc_field_code.contains(".")) {
				String primaryKey = nc_field_code.split(".")[0];
				fieldKey = nc_field_code.split(".")[1];
				for (CircularlyAccessibleValueObject childrenVO : childrenVOs) {
					if (Arrays.asList(childrenVO.getAttributeNames()).contains(
							primaryKey)) {
						Object attributeValue = childrenVO
								.getAttributeValue(fieldKey);
						sourceValue = attributeValue == null ? ""
								: attributeValue.toString();
					}
				}
			} else {
				Object attributeValue = parentVO.getAttributeValue(fieldKey);
				sourceValue = attributeValue == null ? "" : attributeValue
						.toString();
			}
		}
		if (nc.vo.apiplat.exchange.TransLogicStyleEnum.map_style.toInt() == Integer
				.parseInt(ctree.getSourceData().getTrans_logic_style())) {// ӳ��
			if (nc.vo.apiplat.exchange.DefaultTransRuleEnum.null_rule.toInt() == Integer
					.parseInt(ctree.getSourceData().getTrans_rule())) {// ӳ��-�չ���
				ctree.setValue(sourceValue);
			} else if (nc.vo.apiplat.exchange.DefaultTransRuleEnum.name_rule
					.toInt() == Integer.parseInt(ctree.getSourceData()
					.getTrans_rule())) {// ӳ��-���ƹ���
				if ("".equals(sourceValue)) {
					ctree.setValue(sourceValue);
				} else {
					String refInfo = ctree.getSourceData().getName_refinfo();
					String[] refParams = refInfo.split("_");
					SuperVO superVO = (SuperVO) uapQueryBS.retrieveByPK(
							Class.forName(refParams[0]), sourceValue);
					Object attributeValue = superVO
							.getAttributeValue(refParams[1]);
					String value = attributeValue == null ? "" : attributeValue
							.toString();
					ctree.setValue(value);
				}
			} else if (nc.vo.apiplat.exchange.DefaultTransRuleEnum.code_rule
					.toInt() == Integer.parseInt(ctree.getSourceData()
					.getTrans_rule())) {// ӳ��-�������
				if ("".equals(sourceValue)) {
					ctree.setValue(sourceValue);
				} else {
					String refInfo = ctree.getSourceData().getCode_refinfo();
					String[] refParams = refInfo.split("_");
					SuperVO superVO = (SuperVO) uapQueryBS.retrieveByPK(
							Class.forName(refParams[0]), sourceValue);
					Object attributeValue = superVO
							.getAttributeValue(refParams[1]);
					String value = attributeValue == null ? "" : attributeValue
							.toString();
					ctree.setValue(value);
				}
			}
		} else if (nc.vo.apiplat.exchange.TransLogicStyleEnum.assign_style
				.toInt() == Integer.parseInt(ctree.getSourceData()
				.getTrans_logic_style())) {// ��ֵ
			ctree.setValue(ctree.getSourceData().getTrans_sql());
		} else if (nc.vo.apiplat.exchange.TransLogicStyleEnum.sql_style.toInt() == Integer
				.parseInt(ctree.getSourceData().getTrans_logic_style())) {// SQLȡֵ
			if ("".equals(sourceValue)) {
				ctree.setValue(sourceValue);
			} else {
				SQLParameter param = new SQLParameter();
				param.addParam(sourceValue);
				String querySql = ctree.getSourceData().getTrans_sql();
				if (querySql == null || "".equals(querySql.trim())) {
					throw new BusinessException("SQL�����²������SQL");
				}
				Object executeQuery = uapQueryBS.executeQuery(querySql, param,
						new ColumnProcessor());
				sourceValue = executeQuery == null ? "" : executeQuery
						.toString();
				ctree.setValue(sourceValue);
			}
		}
		return ctree;
	}

	/**
	 * ���㼶���򣬴�㼶��ǰ
	 * 
	 * @param ruleVOList
	 */
	private void sortByExtFieldCode(ArrayList<ExchangeRuleVO> ruleVOList) {
		Collections.sort(ruleVOList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				ExchangeRuleVO vo1 = (ExchangeRuleVO) o1;
				ExchangeRuleVO vo2 = (ExchangeRuleVO) o2;
				String ext_field_code1 = vo1.getExt_field_code();
				String ext_field_code2 = vo2.getExt_field_code();
				int count1 = 0;
				int count2 = 0;
				// ��ȡ�ַ������Ӵ��ĸ���
				if (ext_field_code1.contains(".")) {
					int index = -1;
					while ((index = ext_field_code1.indexOf(".", index)) > -1) {
						++index;
						++count1;
					}
				}
				if (ext_field_code2.contains(".")) {
					int index = -1;
					while ((index = ext_field_code2.indexOf(".", index)) > -1) {
						++index;
						++count2;
					}
				}
				return count1 - count2;
			}

		});
	}
}
