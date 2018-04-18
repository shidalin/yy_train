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
 * �ӿ�ƽ̨XML��ʽת������ <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class XmlUtil {

	/**
	 * mapתxml map��û�и��ڵ�ļ�
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
	 * mapתxml map�к��и��ڵ�ļ�
	 * 
	 * @param map
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Document map2xml(Map<String, Object> map)
			throws DocumentException, IOException {
		Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
		if (entries.hasNext()) { // ��ȡ��һ�����������ڵ�
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
	 * mapתxml
	 * 
	 * @param map
	 * @param body
	 *            xmlԪ��
	 * @return
	 */
	private static Element map2xml(Map<String, Object> map, Element body) {
		Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Object> entry = entries.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (key.startsWith("@")) { // ����
				body.addAttribute(key.substring(1, key.length()),
						value.toString());
			} else if (key.equals("#text")) { // ������ʱ���ı�
				body.setText(value.toString());
			} else {
				if (value instanceof java.util.List) {
					List list = (List) value;
					Object obj;
					for (int i = 0; i < list.size(); i++) {
						obj = list.get(i);
						// list����map��String���������list��ֱ����list�ģ�
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
	 * ��ʽ�����xml
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
	 * ��ʽ�����xml
	 * 
	 * @param document
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static String formatXml(Document document) throws DocumentException,
			IOException {
		// ��ʽ�������ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// format.setEncoding("UTF-8");
		StringWriter writer = new StringWriter();
		// ��ʽ�������
		XMLWriter xmlWriter = new XMLWriter(writer, format);
		// ��documentд�뵽�����
		if (document != null) {
			xmlWriter.write(document);
		}
		xmlWriter.close();
		return writer.toString();
	}

}