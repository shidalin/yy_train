package nc.util.apiplat.TreeUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 
 * 接口平台XML格式转换工具 <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class XmlUtil {

	/**
	 * map转xml map中没有根节点的键
	 * 
	 * @param map
	 * @param rootName
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document map2xml(Map<String, Object> map, String rootName)
			throws DocumentException, IOException {
		Document doc = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement(rootName);
		doc.add(root);
		map2xml(map, root);
		return doc;
	}

	/**
	 * map转xml map中含有根节点的键
	 * 
	 * @param map
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document map2xml(Map<String, Object> map)
			throws DocumentException, IOException {
		Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
		if (entries.hasNext()) { // 获取第一个键创建根节点
			Map.Entry<String, Object> entry = entries.next();
			Document doc = DocumentHelper.createDocument();
			Element root = DocumentHelper.createElement(entry.getKey());
			doc.add(root);
			Object list = entry.getValue();
			if (list instanceof ArrayList) {
				for (Object obj : (ArrayList) list) {
					map2xml((Map) obj, root);
				}
			} else {
				map2xml((Map) entry.getValue(), root);
			}
			// System.out.println(doc.asXML());
			// System.out.println(formatXml(doc));
			return doc;
		}
		return null;
	}

	/**
	 * map转xml
	 * 
	 * @param map
	 * @param body
	 *            xml元素
	 * @return
	 */
	private static Element map2xml(Map<String, Object> map, Element body) {
		Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Object> entry = entries.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (key.startsWith("@")) { // 属性
				body.addAttribute(key.substring(1, key.length()),
						value.toString());
			} else if (key.equals("#text")) { // 有属性时的文本
				body.setText(value.toString());
			} else {
				if (value instanceof java.util.List) {
					List list = (List) value;
					Object obj;
					for (int i = 0; i < list.size(); i++) {
						obj = list.get(i);
						// list里是map或String，不会存在list里直接是list的，
						if (obj instanceof java.util.Map) {
							Element subElement = body.addElement(key);
							map2xml((Map) list.get(i), subElement);
						} else {
							body.addElement(key).setText((String) list.get(i));
						}
					}
				} else if (value instanceof java.util.Map) {
					Element subElement = body.addElement(key);
					map2xml((Map) value, subElement);
				} else {
					body.addElement(key).setText(value.toString());
				}
			}
			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());
		}
		return body;
	}

	/**
	 * 格式化输出xml
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static String formatXml(String xmlStr) throws DocumentException,
			IOException {
		Document document = DocumentHelper.parseText(xmlStr);
		return formatXml(document);
	}

	/**
	 * 格式化输出xml
	 * 
	 * @param document
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static String formatXml(Document document) throws DocumentException,
			IOException {
		// 格式化输出格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// format.setEncoding("UTF-8");
		StringWriter writer = new StringWriter();
		// 格式化输出流
		XMLWriter xmlWriter = new XMLWriter(writer, format);
		// 将document写入到输出流
		if (document != null) {
			xmlWriter.write(document);
		}
		xmlWriter.close();
		return writer.toString();
	}

}