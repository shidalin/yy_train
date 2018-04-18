package nc.vo.apiplat.exchange;

/**
 * 
 * �ӿ�ƽ̨����ת������ö���� <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/13<br/>
 */
public enum TransStyleEnum {

	xml_style, json_style;

	public String toString() {
		switch (this) {
		case xml_style:
			return "XML��ʽ";
		case json_style:
			return "JSON��ʽ";
		default:
			break;
		}
		return "";
	}

	public int toInt() {
		switch (this) {
		case xml_style:
			return 1;
		case json_style:
			return 2;
		default:
			break;
		}
		return 0;
	}

	public static TransStyleEnum fromInt(int iType) {
		switch (iType) {
		case 1:
			return xml_style;
		case 2:
			return json_style;
		default:
			break;
		}
		return null;
	}
}
