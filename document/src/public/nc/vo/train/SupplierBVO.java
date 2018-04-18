package nc.vo.train;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/**
 * <b> �˴���Ҫ�������๦�� </b>
 * <p>
 * �˴�����۵�������Ϣ
 * </p>
 * ��������:2017-10-31
 * 
 * @author
 * @version NCPrj ??
 */

public class SupplierBVO extends SuperVO {

	/**
	 * ����
	 */
	public java.lang.String pk_supplier_b;
	/**
	 * ��������
	 */
	public java.lang.String pk_supplier;
	/**
	 * ����
	 */
	public java.lang.String pk_group;
	/**
	 * ��֯
	 */
	public java.lang.String pk_org;
	/**
	 * ��֯��汾
	 */
	public java.lang.String pk_org_v;
	/**
	 * �к�
	 */
	public java.lang.String crowno;
	/**
	 * ��ϵ��
	 */
	public java.lang.String linkman;
	/**
	 * �Ա�
	 */
	public java.lang.Integer sex;
	/**
	 * �绰
	 */
	public java.lang.String phone;
	/**
	 * �ֻ�
	 */
	public java.lang.String mobile;
	/**
	 * �Ƿ�Ĭ��
	 */
	public UFBoolean isdefault;
	/**
	 * ��ע
	 */
	public java.lang.String vmemo;
	/**
	 * �Զ�����1
	 */
	public java.lang.String vbdef1;
	/**
	 * �Զ�����2
	 */
	public java.lang.String vbdef2;
	/**
	 * �Զ�����3
	 */
	public java.lang.String vbdef3;
	/**
	 * �Զ�����4
	 */
	public java.lang.String vbdef4;
	/**
	 * �Զ�����5
	 */
	public java.lang.String vbdef5;
	/**
	 * �Զ�����6
	 */
	public java.lang.String vbdef6;
	/**
	 * �Զ�����7
	 */
	public java.lang.String vbdef7;
	/**
	 * �Զ�����8
	 */
	public java.lang.String vbdef8;
	/**
	 * �Զ�����9
	 */
	public java.lang.String vbdef9;
	/**
	 * �Զ�����10
	 */
	public java.lang.String vbdef10;
	/**
	 * �Զ�����11
	 */
	public java.lang.String vbdef11;
	/**
	 * �Զ�����12
	 */
	public java.lang.String vbdef12;
	/**
	 * �Զ�����13
	 */
	public java.lang.String vbdef13;
	/**
	 * �Զ�����14
	 */
	public java.lang.String vbdef14;
	/**
	 * �Զ�����15
	 */
	public java.lang.String vbdef15;
	/**
	 * �Զ�����16
	 */
	public java.lang.String vbdef16;
	/**
	 * �Զ�����17
	 */
	public java.lang.String vbdef17;
	/**
	 * �Զ�����18
	 */
	public java.lang.String vbdef18;
	/**
	 * �Զ�����19
	 */
	public java.lang.String vbdef19;
	/**
	 * �Զ�����20
	 */
	public java.lang.String vbdef20;
	/**
	 * ʱ���
	 */
	public UFDateTime ts;

	/**
	 * ���� pk_supplier_b��Getter����.������������ ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_supplier_b() {
		return this.pk_supplier_b;
	}

	/**
	 * ����pk_supplier_b��Setter����.������������ ��������:2017-10-31
	 * 
	 * @param newPk_supplier_b
	 *            java.lang.String
	 */
	public void setPk_supplier_b(java.lang.String pk_supplier_b) {
		this.pk_supplier_b = pk_supplier_b;
	}

	/**
	 * ���� pk_group��Getter����.������������ ��������:2017-10-31
	 * 
	 * @return nc.vo.org.GroupVO
	 */
	public java.lang.String getPk_group() {
		return this.pk_group;
	}

	/**
	 * ����pk_group��Setter����.������������ ��������:2017-10-31
	 * 
	 * @param newPk_group
	 *            nc.vo.org.GroupVO
	 */
	public void setPk_group(java.lang.String pk_group) {
		this.pk_group = pk_group;
	}

	/**
	 * ���� pk_org��Getter����.����������֯ ��������:2017-10-31
	 * 
	 * @return nc.vo.org.PurchaseOrgVO
	 */
	public java.lang.String getPk_org() {
		return this.pk_org;
	}

	/**
	 * ����pk_org��Setter����.����������֯ ��������:2017-10-31
	 * 
	 * @param newPk_org
	 *            nc.vo.org.PurchaseOrgVO
	 */
	public void setPk_org(java.lang.String pk_org) {
		this.pk_org = pk_org;
	}

	/**
	 * ���� pk_org_v��Getter����.����������֯��汾 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_org_v() {
		return this.pk_org_v;
	}

	/**
	 * ����pk_org_v��Setter����.����������֯��汾 ��������:2017-10-31
	 * 
	 * @param newPk_org_v
	 *            java.lang.String
	 */
	public void setPk_org_v(java.lang.String pk_org_v) {
		this.pk_org_v = pk_org_v;
	}

	/**
	 * ���� crowno��Getter����.���������к� ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCrowno() {
		return this.crowno;
	}

	/**
	 * ����crowno��Setter����.���������к� ��������:2017-10-31
	 * 
	 * @param newCrowno
	 *            java.lang.String
	 */
	public void setCrowno(java.lang.String crowno) {
		this.crowno = crowno;
	}

	/**
	 * ���� linkman��Getter����.����������ϵ�� ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getLinkman() {
		return this.linkman;
	}

	/**
	 * ����linkman��Setter����.����������ϵ�� ��������:2017-10-31
	 * 
	 * @param newLinkman
	 *            java.lang.String
	 */
	public void setLinkman(java.lang.String linkman) {
		this.linkman = linkman;
	}

	/**
	 * ���� sex��Getter����.���������Ա� ��������:2017-10-31
	 * 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getSex() {
		return this.sex;
	}

	/**
	 * ����sex��Setter����.���������Ա� ��������:2017-10-31
	 * 
	 * @param newSex
	 *            java.lang.Integer
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	/**
	 * ���� phone��Getter����.���������绰 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPhone() {
		return this.phone;
	}

	/**
	 * ����phone��Setter����.���������绰 ��������:2017-10-31
	 * 
	 * @param newPhone
	 *            java.lang.String
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * ���� mobile��Getter����.���������ֻ� ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMobile() {
		return this.mobile;
	}

	/**
	 * ����mobile��Setter����.���������ֻ� ��������:2017-10-31
	 * 
	 * @param newMobile
	 *            java.lang.String
	 */
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	/**
	 * ���� isdefault��Getter����.���������Ƿ�Ĭ�� ��������:2017-10-31
	 * 
	 * @return nc.vo.pub.lang.UFBoolean
	 */
	public UFBoolean getIsdefault() {
		return this.isdefault;
	}

	/**
	 * ����isdefault��Setter����.���������Ƿ�Ĭ�� ��������:2017-10-31
	 * 
	 * @param newIsdefault
	 *            nc.vo.pub.lang.UFBoolean
	 */
	public void setIsdefault(UFBoolean isdefault) {
		this.isdefault = isdefault;
	}

	/**
	 * ���� vmemo��Getter����.����������ע ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVmemo() {
		return this.vmemo;
	}

	/**
	 * ����vmemo��Setter����.����������ע ��������:2017-10-31
	 * 
	 * @param newVmemo
	 *            java.lang.String
	 */
	public void setVmemo(java.lang.String vmemo) {
		this.vmemo = vmemo;
	}

	/**
	 * ���� vbdef1��Getter����.���������Զ�����1 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef1() {
		return this.vbdef1;
	}

	/**
	 * ����vbdef1��Setter����.���������Զ�����1 ��������:2017-10-31
	 * 
	 * @param newVbdef1
	 *            java.lang.String
	 */
	public void setVbdef1(java.lang.String vbdef1) {
		this.vbdef1 = vbdef1;
	}

	/**
	 * ���� vbdef2��Getter����.���������Զ�����2 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef2() {
		return this.vbdef2;
	}

	/**
	 * ����vbdef2��Setter����.���������Զ�����2 ��������:2017-10-31
	 * 
	 * @param newVbdef2
	 *            java.lang.String
	 */
	public void setVbdef2(java.lang.String vbdef2) {
		this.vbdef2 = vbdef2;
	}

	/**
	 * ���� vbdef3��Getter����.���������Զ�����3 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef3() {
		return this.vbdef3;
	}

	/**
	 * ����vbdef3��Setter����.���������Զ�����3 ��������:2017-10-31
	 * 
	 * @param newVbdef3
	 *            java.lang.String
	 */
	public void setVbdef3(java.lang.String vbdef3) {
		this.vbdef3 = vbdef3;
	}

	/**
	 * ���� vbdef4��Getter����.���������Զ�����4 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef4() {
		return this.vbdef4;
	}

	/**
	 * ����vbdef4��Setter����.���������Զ�����4 ��������:2017-10-31
	 * 
	 * @param newVbdef4
	 *            java.lang.String
	 */
	public void setVbdef4(java.lang.String vbdef4) {
		this.vbdef4 = vbdef4;
	}

	/**
	 * ���� vbdef5��Getter����.���������Զ�����5 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef5() {
		return this.vbdef5;
	}

	/**
	 * ����vbdef5��Setter����.���������Զ�����5 ��������:2017-10-31
	 * 
	 * @param newVbdef5
	 *            java.lang.String
	 */
	public void setVbdef5(java.lang.String vbdef5) {
		this.vbdef5 = vbdef5;
	}

	/**
	 * ���� vbdef6��Getter����.���������Զ�����6 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef6() {
		return this.vbdef6;
	}

	/**
	 * ����vbdef6��Setter����.���������Զ�����6 ��������:2017-10-31
	 * 
	 * @param newVbdef6
	 *            java.lang.String
	 */
	public void setVbdef6(java.lang.String vbdef6) {
		this.vbdef6 = vbdef6;
	}

	/**
	 * ���� vbdef7��Getter����.���������Զ�����7 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef7() {
		return this.vbdef7;
	}

	/**
	 * ����vbdef7��Setter����.���������Զ�����7 ��������:2017-10-31
	 * 
	 * @param newVbdef7
	 *            java.lang.String
	 */
	public void setVbdef7(java.lang.String vbdef7) {
		this.vbdef7 = vbdef7;
	}

	/**
	 * ���� vbdef8��Getter����.���������Զ�����8 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef8() {
		return this.vbdef8;
	}

	/**
	 * ����vbdef8��Setter����.���������Զ�����8 ��������:2017-10-31
	 * 
	 * @param newVbdef8
	 *            java.lang.String
	 */
	public void setVbdef8(java.lang.String vbdef8) {
		this.vbdef8 = vbdef8;
	}

	/**
	 * ���� vbdef9��Getter����.���������Զ�����9 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef9() {
		return this.vbdef9;
	}

	/**
	 * ����vbdef9��Setter����.���������Զ�����9 ��������:2017-10-31
	 * 
	 * @param newVbdef9
	 *            java.lang.String
	 */
	public void setVbdef9(java.lang.String vbdef9) {
		this.vbdef9 = vbdef9;
	}

	/**
	 * ���� vbdef10��Getter����.���������Զ�����10 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef10() {
		return this.vbdef10;
	}

	/**
	 * ����vbdef10��Setter����.���������Զ�����10 ��������:2017-10-31
	 * 
	 * @param newVbdef10
	 *            java.lang.String
	 */
	public void setVbdef10(java.lang.String vbdef10) {
		this.vbdef10 = vbdef10;
	}

	/**
	 * ���� vbdef11��Getter����.���������Զ�����11 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef11() {
		return this.vbdef11;
	}

	/**
	 * ����vbdef11��Setter����.���������Զ�����11 ��������:2017-10-31
	 * 
	 * @param newVbdef11
	 *            java.lang.String
	 */
	public void setVbdef11(java.lang.String vbdef11) {
		this.vbdef11 = vbdef11;
	}

	/**
	 * ���� vbdef12��Getter����.���������Զ�����12 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef12() {
		return this.vbdef12;
	}

	/**
	 * ����vbdef12��Setter����.���������Զ�����12 ��������:2017-10-31
	 * 
	 * @param newVbdef12
	 *            java.lang.String
	 */
	public void setVbdef12(java.lang.String vbdef12) {
		this.vbdef12 = vbdef12;
	}

	/**
	 * ���� vbdef13��Getter����.���������Զ�����13 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef13() {
		return this.vbdef13;
	}

	/**
	 * ����vbdef13��Setter����.���������Զ�����13 ��������:2017-10-31
	 * 
	 * @param newVbdef13
	 *            java.lang.String
	 */
	public void setVbdef13(java.lang.String vbdef13) {
		this.vbdef13 = vbdef13;
	}

	/**
	 * ���� vbdef14��Getter����.���������Զ�����14 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef14() {
		return this.vbdef14;
	}

	/**
	 * ����vbdef14��Setter����.���������Զ�����14 ��������:2017-10-31
	 * 
	 * @param newVbdef14
	 *            java.lang.String
	 */
	public void setVbdef14(java.lang.String vbdef14) {
		this.vbdef14 = vbdef14;
	}

	/**
	 * ���� vbdef15��Getter����.���������Զ�����15 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef15() {
		return this.vbdef15;
	}

	/**
	 * ����vbdef15��Setter����.���������Զ�����15 ��������:2017-10-31
	 * 
	 * @param newVbdef15
	 *            java.lang.String
	 */
	public void setVbdef15(java.lang.String vbdef15) {
		this.vbdef15 = vbdef15;
	}

	/**
	 * ���� vbdef16��Getter����.���������Զ�����16 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef16() {
		return this.vbdef16;
	}

	/**
	 * ����vbdef16��Setter����.���������Զ�����16 ��������:2017-10-31
	 * 
	 * @param newVbdef16
	 *            java.lang.String
	 */
	public void setVbdef16(java.lang.String vbdef16) {
		this.vbdef16 = vbdef16;
	}

	/**
	 * ���� vbdef17��Getter����.���������Զ�����17 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef17() {
		return this.vbdef17;
	}

	/**
	 * ����vbdef17��Setter����.���������Զ�����17 ��������:2017-10-31
	 * 
	 * @param newVbdef17
	 *            java.lang.String
	 */
	public void setVbdef17(java.lang.String vbdef17) {
		this.vbdef17 = vbdef17;
	}

	/**
	 * ���� vbdef18��Getter����.���������Զ�����18 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef18() {
		return this.vbdef18;
	}

	/**
	 * ����vbdef18��Setter����.���������Զ�����18 ��������:2017-10-31
	 * 
	 * @param newVbdef18
	 *            java.lang.String
	 */
	public void setVbdef18(java.lang.String vbdef18) {
		this.vbdef18 = vbdef18;
	}

	/**
	 * ���� vbdef19��Getter����.���������Զ�����19 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef19() {
		return this.vbdef19;
	}

	/**
	 * ����vbdef19��Setter����.���������Զ�����19 ��������:2017-10-31
	 * 
	 * @param newVbdef19
	 *            java.lang.String
	 */
	public void setVbdef19(java.lang.String vbdef19) {
		this.vbdef19 = vbdef19;
	}

	/**
	 * ���� vbdef20��Getter����.���������Զ�����20 ��������:2017-10-31
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef20() {
		return this.vbdef20;
	}

	/**
	 * ����vbdef20��Setter����.���������Զ�����20 ��������:2017-10-31
	 * 
	 * @param newVbdef20
	 *            java.lang.String
	 */
	public void setVbdef20(java.lang.String vbdef20) {
		this.vbdef20 = vbdef20;
	}

	/**
	 * ���� �����ϲ�������Getter����.���������ϲ����� ��������:2017-10-31
	 * 
	 * @return String
	 */
	public String getPk_supplier() {
		return this.pk_supplier;
	}

	/**
	 * ���������ϲ�������Setter����.���������ϲ����� ��������:2017-10-31
	 * 
	 * @param newPk_supplier
	 *            String
	 */
	public void setPk_supplier(String pk_supplier) {
		this.pk_supplier = pk_supplier;
	}

	/**
	 * ���� ����ʱ�����Getter����.��������ʱ��� ��������:2017-10-31
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTs() {
		return this.ts;
	}

	/**
	 * ��������ʱ�����Setter����.��������ʱ��� ��������:2017-10-31
	 * 
	 * @param newts
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTs(UFDateTime ts) {
		this.ts = ts;
	}

	@Override
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("train.supplierItem");
	}

	/**
	 * ������������
	 */
	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return "pk_supplier";
	}
	
	
	
}
