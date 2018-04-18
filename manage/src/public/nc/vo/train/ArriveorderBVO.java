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
 * ��������:2017-11-2
 * 
 * @author YONYOU NC
 * @version NCPrj ??
 */

public class ArriveorderBVO extends SuperVO {

	/**
	 * ����
	 */
	public java.lang.String pk_arrive_b;
	/**
	 * ��������
	 */
	public java.lang.String pk_arrive;
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
	 * ���ϱ���
	 */
	public java.lang.String pk_material;
	/**
	 * �к�
	 */
	public java.lang.String crowno;
	/**
	 * ����
	 */
	public nc.vo.pub.lang.UFDouble nnum;
	/**
	 * ����
	 */
	public nc.vo.pub.lang.UFDouble nprice;
	/**
	 * ���
	 */
	public nc.vo.pub.lang.UFDouble nmny;
	/**
	 * ��Դ��������
	 */
	public java.lang.String csourcetypecode;
	/**
	 * ��Դ���ݺ�
	 */
	public java.lang.String vsourcecode;
	/**
	 * ��Դ����
	 */
	public java.lang.String csourceid;
	/**
	 * ��Դ������ϸ
	 */
	public java.lang.String csourcebid;
	/**
	 * ��Դ�����к�
	 */
	public java.lang.String vsourcerowno;
	/**
	 * ��Դ��������
	 */
	public java.lang.String vsourcetrantype;
	/**
	 * Դͷ��������
	 */
	public java.lang.String cfirsttypecode;
	/**
	 * Դͷ���ݺ�
	 */
	public java.lang.String vfirstcode;
	/**
	 * Դͷ������������
	 */
	public java.lang.String cfirstid;
	/**
	 * Դͷ������ϸ
	 */
	public java.lang.String cfirstbid;
	/**
	 * Դͷ�����к�
	 */
	public java.lang.String vfirstrowno;
	/**
	 * Դͷ��������
	 */
	public java.lang.String vfirsttrantype;
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
	 * ���� pk_arrive_b��Getter����.������������ ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_arrive_b() {
		return this.pk_arrive_b;
	}

	/**
	 * ����pk_arrive_b��Setter����.������������ ��������:2017-11-2
	 * 
	 * @param newPk_arrive_b
	 *            java.lang.String
	 */
	public void setPk_arrive_b(java.lang.String pk_arrive_b) {
		this.pk_arrive_b = pk_arrive_b;
	}

	/**
	 * ���� pk_arrive��Getter����.���������������� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPk_arrive() {
		return this.pk_arrive;
	}

	/**
	 * ����pk_arrive��Setter����.���������������� ��������:2017-11-2
	 * 
	 * @param newPk_arrive
	 *            java.lang.String
	 */
	public void setPk_arrive(java.lang.String pk_arrive) {
		this.pk_arrive = pk_arrive;
	}

	/**
	 * ���� pk_group��Getter����.������������ ��������:2017-11-2
	 * 
	 * @return nc.vo.org.GroupVO
	 */
	public java.lang.String getPk_group() {
		return this.pk_group;
	}

	/**
	 * ����pk_group��Setter����.������������ ��������:2017-11-2
	 * 
	 * @param newPk_group
	 *            nc.vo.org.GroupVO
	 */
	public void setPk_group(java.lang.String pk_group) {
		this.pk_group = pk_group;
	}

	/**
	 * ���� pk_org��Getter����.����������֯ ��������:2017-11-2
	 * 
	 * @return nc.vo.org.PurchaseOrgVO
	 */
	public java.lang.String getPk_org() {
		return this.pk_org;
	}

	/**
	 * ����pk_org��Setter����.����������֯ ��������:2017-11-2
	 * 
	 * @param newPk_org
	 *            nc.vo.org.PurchaseOrgVO
	 */
	public void setPk_org(java.lang.String pk_org) {
		this.pk_org = pk_org;
	}

	/**
	 * ���� pk_org_v��Getter����.����������֯��汾 ��������:2017-11-2
	 * 
	 * @return nc.vo.vorg.PurchaseOrgVersionVO
	 */
	public java.lang.String getPk_org_v() {
		return this.pk_org_v;
	}

	/**
	 * ����pk_org_v��Setter����.����������֯��汾 ��������:2017-11-2
	 * 
	 * @param newPk_org_v
	 *            nc.vo.vorg.PurchaseOrgVersionVO
	 */
	public void setPk_org_v(java.lang.String pk_org_v) {
		this.pk_org_v = pk_org_v;
	}

	/**
	 * ���� pk_material��Getter����.�����������ϱ��� ��������:2017-11-2
	 * 
	 * @return nc.vo.bd.material.MaterialVO
	 */
	public java.lang.String getPk_material() {
		return this.pk_material;
	}

	/**
	 * ����pk_material��Setter����.�����������ϱ��� ��������:2017-11-2
	 * 
	 * @param newPk_material
	 *            nc.vo.bd.material.MaterialVO
	 */
	public void setPk_material(java.lang.String pk_material) {
		this.pk_material = pk_material;
	}

	/**
	 * ���� crowno��Getter����.���������к� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCrowno() {
		return this.crowno;
	}

	/**
	 * ����crowno��Setter����.���������к� ��������:2017-11-2
	 * 
	 * @param newCrowno
	 *            java.lang.String
	 */
	public void setCrowno(java.lang.String crowno) {
		this.crowno = crowno;
	}

	/**
	 * ���� nnum��Getter����.������������ ��������:2017-11-2
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getNnum() {
		return this.nnum;
	}

	/**
	 * ����nnum��Setter����.������������ ��������:2017-11-2
	 * 
	 * @param newNnum
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNnum(nc.vo.pub.lang.UFDouble nnum) {
		this.nnum = nnum;
	}

	/**
	 * ���� nprice��Getter����.������������ ��������:2017-11-2
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getNprice() {
		return this.nprice;
	}

	/**
	 * ����nprice��Setter����.������������ ��������:2017-11-2
	 * 
	 * @param newNprice
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNprice(nc.vo.pub.lang.UFDouble nprice) {
		this.nprice = nprice;
	}

	/**
	 * ���� nmny��Getter����.����������� ��������:2017-11-2
	 * 
	 * @return nc.vo.pub.lang.UFDouble
	 */
	public nc.vo.pub.lang.UFDouble getNmny() {
		return this.nmny;
	}

	/**
	 * ����nmny��Setter����.����������� ��������:2017-11-2
	 * 
	 * @param newNmny
	 *            nc.vo.pub.lang.UFDouble
	 */
	public void setNmny(nc.vo.pub.lang.UFDouble nmny) {
		this.nmny = nmny;
	}

	/**
	 * ���� csourcetypecode��Getter����.����������Դ�������� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCsourcetypecode() {
		return this.csourcetypecode;
	}

	/**
	 * ����csourcetypecode��Setter����.����������Դ�������� ��������:2017-11-2
	 * 
	 * @param newCsourcetypecode
	 *            java.lang.String
	 */
	public void setCsourcetypecode(java.lang.String csourcetypecode) {
		this.csourcetypecode = csourcetypecode;
	}

	/**
	 * ���� vsourcecode��Getter����.����������Դ���ݺ� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVsourcecode() {
		return this.vsourcecode;
	}

	/**
	 * ����vsourcecode��Setter����.����������Դ���ݺ� ��������:2017-11-2
	 * 
	 * @param newVsourcecode
	 *            java.lang.String
	 */
	public void setVsourcecode(java.lang.String vsourcecode) {
		this.vsourcecode = vsourcecode;
	}

	/**
	 * ���� csourceid��Getter����.����������Դ���� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCsourceid() {
		return this.csourceid;
	}

	/**
	 * ����csourceid��Setter����.����������Դ���� ��������:2017-11-2
	 * 
	 * @param newCsourceid
	 *            java.lang.String
	 */
	public void setCsourceid(java.lang.String csourceid) {
		this.csourceid = csourceid;
	}

	/**
	 * ���� csourcebid��Getter����.����������Դ������ϸ ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCsourcebid() {
		return this.csourcebid;
	}

	/**
	 * ����csourcebid��Setter����.����������Դ������ϸ ��������:2017-11-2
	 * 
	 * @param newCsourcebid
	 *            java.lang.String
	 */
	public void setCsourcebid(java.lang.String csourcebid) {
		this.csourcebid = csourcebid;
	}

	/**
	 * ���� vsourcerowno��Getter����.����������Դ�����к� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVsourcerowno() {
		return this.vsourcerowno;
	}

	/**
	 * ����vsourcerowno��Setter����.����������Դ�����к� ��������:2017-11-2
	 * 
	 * @param newVsourcerowno
	 *            java.lang.String
	 */
	public void setVsourcerowno(java.lang.String vsourcerowno) {
		this.vsourcerowno = vsourcerowno;
	}

	/**
	 * ���� vsourcetrantype��Getter����.����������Դ�������� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVsourcetrantype() {
		return this.vsourcetrantype;
	}

	/**
	 * ����vsourcetrantype��Setter����.����������Դ�������� ��������:2017-11-2
	 * 
	 * @param newVsourcetrantype
	 *            java.lang.String
	 */
	public void setVsourcetrantype(java.lang.String vsourcetrantype) {
		this.vsourcetrantype = vsourcetrantype;
	}

	/**
	 * ���� cfirsttypecode��Getter����.��������Դͷ�������� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCfirsttypecode() {
		return this.cfirsttypecode;
	}

	/**
	 * ����cfirsttypecode��Setter����.��������Դͷ�������� ��������:2017-11-2
	 * 
	 * @param newCfirsttypecode
	 *            java.lang.String
	 */
	public void setCfirsttypecode(java.lang.String cfirsttypecode) {
		this.cfirsttypecode = cfirsttypecode;
	}

	/**
	 * ���� vfirstcode��Getter����.��������Դͷ���ݺ� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVfirstcode() {
		return this.vfirstcode;
	}

	/**
	 * ����vfirstcode��Setter����.��������Դͷ���ݺ� ��������:2017-11-2
	 * 
	 * @param newVfirstcode
	 *            java.lang.String
	 */
	public void setVfirstcode(java.lang.String vfirstcode) {
		this.vfirstcode = vfirstcode;
	}

	/**
	 * ���� cfirstid��Getter����.��������Դͷ������������ ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCfirstid() {
		return this.cfirstid;
	}

	/**
	 * ����cfirstid��Setter����.��������Դͷ������������ ��������:2017-11-2
	 * 
	 * @param newCfirstid
	 *            java.lang.String
	 */
	public void setCfirstid(java.lang.String cfirstid) {
		this.cfirstid = cfirstid;
	}

	/**
	 * ���� cfirstbid��Getter����.��������Դͷ������ϸ ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCfirstbid() {
		return this.cfirstbid;
	}

	/**
	 * ����cfirstbid��Setter����.��������Դͷ������ϸ ��������:2017-11-2
	 * 
	 * @param newCfirstbid
	 *            java.lang.String
	 */
	public void setCfirstbid(java.lang.String cfirstbid) {
		this.cfirstbid = cfirstbid;
	}

	/**
	 * ���� vfirstrowno��Getter����.��������Դͷ�����к� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVfirstrowno() {
		return this.vfirstrowno;
	}

	/**
	 * ����vfirstrowno��Setter����.��������Դͷ�����к� ��������:2017-11-2
	 * 
	 * @param newVfirstrowno
	 *            java.lang.String
	 */
	public void setVfirstrowno(java.lang.String vfirstrowno) {
		this.vfirstrowno = vfirstrowno;
	}

	/**
	 * ���� vfirsttrantype��Getter����.��������Դͷ�������� ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVfirsttrantype() {
		return this.vfirsttrantype;
	}

	/**
	 * ����vfirsttrantype��Setter����.��������Դͷ�������� ��������:2017-11-2
	 * 
	 * @param newVfirsttrantype
	 *            java.lang.String
	 */
	public void setVfirsttrantype(java.lang.String vfirsttrantype) {
		this.vfirsttrantype = vfirsttrantype;
	}

	/**
	 * ���� vmemo��Getter����.����������ע ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVmemo() {
		return this.vmemo;
	}

	/**
	 * ����vmemo��Setter����.����������ע ��������:2017-11-2
	 * 
	 * @param newVmemo
	 *            java.lang.String
	 */
	public void setVmemo(java.lang.String vmemo) {
		this.vmemo = vmemo;
	}

	/**
	 * ���� vbdef1��Getter����.���������Զ�����1 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef1() {
		return this.vbdef1;
	}

	/**
	 * ����vbdef1��Setter����.���������Զ�����1 ��������:2017-11-2
	 * 
	 * @param newVbdef1
	 *            java.lang.String
	 */
	public void setVbdef1(java.lang.String vbdef1) {
		this.vbdef1 = vbdef1;
	}

	/**
	 * ���� vbdef2��Getter����.���������Զ�����2 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef2() {
		return this.vbdef2;
	}

	/**
	 * ����vbdef2��Setter����.���������Զ�����2 ��������:2017-11-2
	 * 
	 * @param newVbdef2
	 *            java.lang.String
	 */
	public void setVbdef2(java.lang.String vbdef2) {
		this.vbdef2 = vbdef2;
	}

	/**
	 * ���� vbdef3��Getter����.���������Զ�����3 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef3() {
		return this.vbdef3;
	}

	/**
	 * ����vbdef3��Setter����.���������Զ�����3 ��������:2017-11-2
	 * 
	 * @param newVbdef3
	 *            java.lang.String
	 */
	public void setVbdef3(java.lang.String vbdef3) {
		this.vbdef3 = vbdef3;
	}

	/**
	 * ���� vbdef4��Getter����.���������Զ�����4 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef4() {
		return this.vbdef4;
	}

	/**
	 * ����vbdef4��Setter����.���������Զ�����4 ��������:2017-11-2
	 * 
	 * @param newVbdef4
	 *            java.lang.String
	 */
	public void setVbdef4(java.lang.String vbdef4) {
		this.vbdef4 = vbdef4;
	}

	/**
	 * ���� vbdef5��Getter����.���������Զ�����5 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef5() {
		return this.vbdef5;
	}

	/**
	 * ����vbdef5��Setter����.���������Զ�����5 ��������:2017-11-2
	 * 
	 * @param newVbdef5
	 *            java.lang.String
	 */
	public void setVbdef5(java.lang.String vbdef5) {
		this.vbdef5 = vbdef5;
	}

	/**
	 * ���� vbdef6��Getter����.���������Զ�����6 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef6() {
		return this.vbdef6;
	}

	/**
	 * ����vbdef6��Setter����.���������Զ�����6 ��������:2017-11-2
	 * 
	 * @param newVbdef6
	 *            java.lang.String
	 */
	public void setVbdef6(java.lang.String vbdef6) {
		this.vbdef6 = vbdef6;
	}

	/**
	 * ���� vbdef7��Getter����.���������Զ�����7 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef7() {
		return this.vbdef7;
	}

	/**
	 * ����vbdef7��Setter����.���������Զ�����7 ��������:2017-11-2
	 * 
	 * @param newVbdef7
	 *            java.lang.String
	 */
	public void setVbdef7(java.lang.String vbdef7) {
		this.vbdef7 = vbdef7;
	}

	/**
	 * ���� vbdef8��Getter����.���������Զ�����8 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef8() {
		return this.vbdef8;
	}

	/**
	 * ����vbdef8��Setter����.���������Զ�����8 ��������:2017-11-2
	 * 
	 * @param newVbdef8
	 *            java.lang.String
	 */
	public void setVbdef8(java.lang.String vbdef8) {
		this.vbdef8 = vbdef8;
	}

	/**
	 * ���� vbdef9��Getter����.���������Զ�����9 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef9() {
		return this.vbdef9;
	}

	/**
	 * ����vbdef9��Setter����.���������Զ�����9 ��������:2017-11-2
	 * 
	 * @param newVbdef9
	 *            java.lang.String
	 */
	public void setVbdef9(java.lang.String vbdef9) {
		this.vbdef9 = vbdef9;
	}

	/**
	 * ���� vbdef10��Getter����.���������Զ�����10 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef10() {
		return this.vbdef10;
	}

	/**
	 * ����vbdef10��Setter����.���������Զ�����10 ��������:2017-11-2
	 * 
	 * @param newVbdef10
	 *            java.lang.String
	 */
	public void setVbdef10(java.lang.String vbdef10) {
		this.vbdef10 = vbdef10;
	}

	/**
	 * ���� vbdef11��Getter����.���������Զ�����11 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef11() {
		return this.vbdef11;
	}

	/**
	 * ����vbdef11��Setter����.���������Զ�����11 ��������:2017-11-2
	 * 
	 * @param newVbdef11
	 *            java.lang.String
	 */
	public void setVbdef11(java.lang.String vbdef11) {
		this.vbdef11 = vbdef11;
	}

	/**
	 * ���� vbdef12��Getter����.���������Զ�����12 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef12() {
		return this.vbdef12;
	}

	/**
	 * ����vbdef12��Setter����.���������Զ�����12 ��������:2017-11-2
	 * 
	 * @param newVbdef12
	 *            java.lang.String
	 */
	public void setVbdef12(java.lang.String vbdef12) {
		this.vbdef12 = vbdef12;
	}

	/**
	 * ���� vbdef13��Getter����.���������Զ�����13 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef13() {
		return this.vbdef13;
	}

	/**
	 * ����vbdef13��Setter����.���������Զ�����13 ��������:2017-11-2
	 * 
	 * @param newVbdef13
	 *            java.lang.String
	 */
	public void setVbdef13(java.lang.String vbdef13) {
		this.vbdef13 = vbdef13;
	}

	/**
	 * ���� vbdef14��Getter����.���������Զ�����14 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef14() {
		return this.vbdef14;
	}

	/**
	 * ����vbdef14��Setter����.���������Զ�����14 ��������:2017-11-2
	 * 
	 * @param newVbdef14
	 *            java.lang.String
	 */
	public void setVbdef14(java.lang.String vbdef14) {
		this.vbdef14 = vbdef14;
	}

	/**
	 * ���� vbdef15��Getter����.���������Զ�����15 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef15() {
		return this.vbdef15;
	}

	/**
	 * ����vbdef15��Setter����.���������Զ�����15 ��������:2017-11-2
	 * 
	 * @param newVbdef15
	 *            java.lang.String
	 */
	public void setVbdef15(java.lang.String vbdef15) {
		this.vbdef15 = vbdef15;
	}

	/**
	 * ���� vbdef16��Getter����.���������Զ�����16 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef16() {
		return this.vbdef16;
	}

	/**
	 * ����vbdef16��Setter����.���������Զ�����16 ��������:2017-11-2
	 * 
	 * @param newVbdef16
	 *            java.lang.String
	 */
	public void setVbdef16(java.lang.String vbdef16) {
		this.vbdef16 = vbdef16;
	}

	/**
	 * ���� vbdef17��Getter����.���������Զ�����17 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef17() {
		return this.vbdef17;
	}

	/**
	 * ����vbdef17��Setter����.���������Զ�����17 ��������:2017-11-2
	 * 
	 * @param newVbdef17
	 *            java.lang.String
	 */
	public void setVbdef17(java.lang.String vbdef17) {
		this.vbdef17 = vbdef17;
	}

	/**
	 * ���� vbdef18��Getter����.���������Զ�����18 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef18() {
		return this.vbdef18;
	}

	/**
	 * ����vbdef18��Setter����.���������Զ�����18 ��������:2017-11-2
	 * 
	 * @param newVbdef18
	 *            java.lang.String
	 */
	public void setVbdef18(java.lang.String vbdef18) {
		this.vbdef18 = vbdef18;
	}

	/**
	 * ���� vbdef19��Getter����.���������Զ�����19 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef19() {
		return this.vbdef19;
	}

	/**
	 * ����vbdef19��Setter����.���������Զ�����19 ��������:2017-11-2
	 * 
	 * @param newVbdef19
	 *            java.lang.String
	 */
	public void setVbdef19(java.lang.String vbdef19) {
		this.vbdef19 = vbdef19;
	}

	/**
	 * ���� vbdef20��Getter����.���������Զ�����20 ��������:2017-11-2
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVbdef20() {
		return this.vbdef20;
	}

	/**
	 * ����vbdef20��Setter����.���������Զ�����20 ��������:2017-11-2
	 * 
	 * @param newVbdef20
	 *            java.lang.String
	 */
	public void setVbdef20(java.lang.String vbdef20) {
		this.vbdef20 = vbdef20;
	}

	/**
	 * ���� ����ʱ�����Getter����.��������ʱ��� ��������:2017-11-2
	 * 
	 * @return nc.vo.pub.lang.UFDateTime
	 */
	public UFDateTime getTs() {
		return this.ts;
	}

	/**
	 * ��������ʱ�����Setter����.��������ʱ��� ��������:2017-11-2
	 * 
	 * @param newts
	 *            nc.vo.pub.lang.UFDateTime
	 */
	public void setTs(UFDateTime ts) {
		this.ts = ts;
	}

	@Override
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("train.arriveorderItem");
	}
}
