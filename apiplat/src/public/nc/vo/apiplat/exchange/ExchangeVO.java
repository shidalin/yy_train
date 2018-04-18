package nc.vo.apiplat.exchange;

import java.util.ArrayList;

import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDate;

/**
 * 接口平台数据转换主表VO <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/12<br/>
 */
public class ExchangeVO extends SuperVO {

	private UFDate ts = null;

	public UFDate getTs() {
		return ts;
	}

	public void setTs(UFDate ts) {
		this.ts = ts;
	}

	@Override
	public String getPKFieldName() {
		return "pk_apiplat_trans";
	}

	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		return "pub_apiplat_trans";
	}

	private ArrayList<ExchangeRuleVO> alRuleVO = null;

	public ArrayList<ExchangeRuleVO> getRuleVOList() {
		if (this.alRuleVO == null) {
			this.alRuleVO = new ArrayList();
		}

		return this.alRuleVO;
	}

	public void setRuleVOList(ArrayList<ExchangeRuleVO> alRuleVO) {
		this.alRuleVO = alRuleVO;
	}

	/**
	 * 主键
	 */
	private String pk_apiplat_trans;
	/**
	 * 外系统编码
	 */
	private String ext_code;
	/**
	 * 外系统名称
	 */
	private String ext_name;
	/**
	 * 外系统单据编码
	 */
	private String ext_bill_code;
	/**
	 * 外系统单据名称
	 */
	private String ext_bill_name;
	/**
	 * 默认翻译规则
	 */
	private String default_trans_rule;
	/**
	 * 数据交换格式:XML/JSON
	 */
	private String trans_style;
	/**
	 * NC单据类型
	 */
	private String nc_bill_type;

	public String getPk_apiplat_trans() {
		return pk_apiplat_trans;
	}

	public void setPk_apiplat_trans(String pk_apiflat_trans) {
		this.pk_apiplat_trans = pk_apiflat_trans;
	}

	public String getExt_code() {
		return ext_code;
	}

	public void setExt_code(String ext_code) {
		this.ext_code = ext_code;
	}

	public String getExt_name() {
		return ext_name;
	}

	public void setExt_name(String ext_name) {
		this.ext_name = ext_name;
	}

	public String getExt_bill_code() {
		return ext_bill_code;
	}

	public void setExt_bill_code(String ext_bill_code) {
		this.ext_bill_code = ext_bill_code;
	}

	public String getExt_bill_name() {
		return ext_bill_name;
	}

	public void setExt_bill_name(String ext_bill_name) {
		this.ext_bill_name = ext_bill_name;
	}

	public String getDefault_trans_rule() {
		return default_trans_rule;
	}

	public void setDefault_trans_rule(String default_trans_rule) {
		this.default_trans_rule = default_trans_rule;
	}

	public String getTrans_style() {
		return trans_style;
	}

	public void setTrans_style(String trans_style) {
		this.trans_style = trans_style;
	}

	public String getNc_bill_type() {
		return nc_bill_type;
	}

	public void setNc_bill_type(String nc_bill_type) {
		this.nc_bill_type = nc_bill_type;
	}

}
