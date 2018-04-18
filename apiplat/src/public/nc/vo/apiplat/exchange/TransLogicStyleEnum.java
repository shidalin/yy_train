package nc.vo.apiplat.exchange;

public enum TransLogicStyleEnum {
	map_style, assign_style, sql_style;

	public String toString() {
		switch (this) {
		case map_style:
			return "”≥…‰";
		case assign_style:
			return "∏≥÷µ";
		case sql_style:
			return "SQL";
		default:
			break;
		}
		return "";
	}

	public int toInt() {
		switch (this) {
		case map_style:
			return 1;
		case assign_style:
			return 2;
		case sql_style:
			return 3;
		default:
			break;
		}
		return 0;
	}

	public static TransLogicStyleEnum fromInt(int iType) {
		switch (iType) {
		case 1:
			return map_style;
		case 2:
			return assign_style;
		case 3:
			return sql_style;
		default:
			break;
		}
		return null;
	}
}
