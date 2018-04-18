package nc.vo.apiplat.exchange;


/**
 * 
 * 接口平台数据默认翻译规则枚举类 <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/13<br/>
 * 
 */
public enum DefaultTransRuleEnum {

	null_rule, name_rule, code_rule;

	public String toString() {
		switch (this) {
		case null_rule:
			return "";
		case name_rule:
			return "名称";
		case code_rule:
			return "编码";
		default:
			break;
		}
		return "";
	}

	public int toInt() {
		switch (this) {
		case null_rule:
			return 0;
		case name_rule:
			return 1;
		case code_rule:
			return 2;
		default:
			break;
		}
		return 0;
	}

	public static DefaultTransRuleEnum fromInt(int iType) {
		switch (iType) {
		case 1:
			return name_rule;
		case 2:
			return code_rule;
		case 0:
			return null_rule;
		default:
			break;
		}
		return null;
	}

}
