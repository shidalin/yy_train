package nc.vo.apiplat.exchange;

import java.util.HashMap;

import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDateTime;

/**
 * 接口平台数据转换子表VO <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/12<br/>
 */
public class ExchangeRuleVO extends SuperVO {

	@Override
	public String getPKFieldName() {
		return "pk_apiplat_trans_b";
	}

	@Override
	public String getParentPKFieldName() {
		return "pk_apiplat_trans";
	}

	@Override
	public String getTableName() {
		return "pub_apiplat_trans_b";
	}

	private UFDateTime ts;
	/**
	 * 主表主键
	 */
	private String pk_apiplat_trans;
	/**
	 * 主键
	 */
	private String pk_apiplat_trans_b;
	/**
	 * nc属性编码
	 */
	private String nc_field_code;
	/**
	 * nc属性名称
	 */
	private String nc_field_name;
	/**
	 * nc属性是否必输（发送数据不要求填写）
	 */
	private String nc_field_isrequire;
	/**
	 * 交换类型：映射/赋值/SQL
	 */
	private String trans_logic_style;
	/**
	 * 翻译规则：名称/编码
	 */
	private String trans_rule;
	/**
	 * 翻译SQL:与翻译类型互斥
	 */
	private String trans_sql;
	/**
	 * 外系统属性名称
	 */
	private String ext_field_name;
	/**
	 * 外系统属性编码
	 */
	private String ext_field_code;

	/**
	 * 存储参照对应的信息
	 */
	private String code_refinfo;

	private String name_refinfo;

	public UFDateTime getTs() {
		return ts;
	}

	public void setTs(UFDateTime ts) {
		this.ts = ts;
	}

	public String getPk_apiplat_trans() {
		return pk_apiplat_trans;
	}

	public void setPk_apiplat_trans(String pk_apiplat_trans) {
		this.pk_apiplat_trans = pk_apiplat_trans;
	}

	public String getPk_apiplat_trans_b() {
		return pk_apiplat_trans_b;
	}

	public void setPk_apiplat_trans_b(String pk_apiplat_trans_b) {
		this.pk_apiplat_trans_b = pk_apiplat_trans_b;
	}

	public String getNc_field_code() {
		return nc_field_code;
	}

	public void setNc_field_code(String nc_field_code) {
		this.nc_field_code = nc_field_code;
	}

	public String getNc_field_name() {
		return nc_field_name;
	}

	public void setNc_field_name(String nc_field_name) {
		this.nc_field_name = nc_field_name;
	}

	public String getNc_field_isrequire() {
		return nc_field_isrequire;
	}

	public void setNc_field_isrequire(String nc_field_isrequire) {
		this.nc_field_isrequire = nc_field_isrequire;
	}

	public String getTrans_logic_style() {
		return trans_logic_style;
	}

	public void setTrans_logic_style(String trans_logic_style) {
		this.trans_logic_style = trans_logic_style;
	}

	public String getTrans_rule() {
		return trans_rule;
	}

	public void setTrans_rule(String trans_rule) {
		this.trans_rule = trans_rule;
	}

	public String getTrans_sql() {
		return trans_sql;
	}

	public void setTrans_sql(String trans_sql) {
		this.trans_sql = trans_sql;
	}

	public String getExt_field_name() {
		return ext_field_name;
	}

	public void setExt_field_name(String ext_field_name) {
		this.ext_field_name = ext_field_name;
	}

	public String getExt_field_code() {
		return ext_field_code;
	}

	public void setExt_field_code(String ext_field_code) {
		this.ext_field_code = ext_field_code;
	}

	public String getCode_refinfo() {
		return code_refinfo;
	}

	public void setCode_refinfo(String code_refinfo) {
		this.code_refinfo = code_refinfo;
	}

	public String getName_refinfo() {
		return name_refinfo;
	}

	public void setName_refinfo(String name_refinfo) {
		this.name_refinfo = name_refinfo;
	}

}
