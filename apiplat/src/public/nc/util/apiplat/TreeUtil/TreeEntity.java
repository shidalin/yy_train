package nc.util.apiplat.TreeUtil;

import java.util.ArrayList;
import java.util.List;

import nc.vo.apiplat.exchange.ExchangeRuleVO;

/**
 * 
 * 接口平台树结构类 <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public class TreeEntity {

	private String id;
	private String code;
	private String value;
	private String fatherId;
	private int level;
	private boolean isleaf;
	private ExchangeRuleVO sourceData;
	private List<TreeEntity> childList = new ArrayList<TreeEntity>();
    
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isIsleaf() {
		return isleaf;
	}

	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}

	public List<TreeEntity> getChildList() {
		return childList;
	}

	public void setChildList(List<TreeEntity> childList) {
		this.childList = childList;
	}

	public ExchangeRuleVO getSourceData() {
		return sourceData;
	}

	public void setSourceData(ExchangeRuleVO sourceData) {
		this.sourceData = sourceData;
	}

}