package nc.vo.train;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/**
 * <b> 此处简要描述此类功能 </b>
 * <p>
 *   此处添加累的描述信息
 * </p>
 *  创建日期:2017-10-31
 * @author YONYOU NC
 * @version NCPrj ??
 */
 
public class OrderVO extends SuperVO {
	
/**
*主键
*/
public java.lang.String pk_order;
/**
*集团
*/
public java.lang.String pk_group;
/**
*组织
*/
public java.lang.String pk_org;
/**
*组织多版本
*/
public java.lang.String pk_org_v;
/**
*订单编号
*/
public java.lang.String vbillno;
/**
*订单日期
*/
public UFDate dbilldate;
/**
*单据状态
*/
public java.lang.Integer vbillstatus;
/**
*单据类型编码
*/
public java.lang.String pk_billtypecode;
/**
*单据类型
*/
public java.lang.String pk_billtypeid;
/**
*业务类型
*/
public java.lang.String pk_busitype;
/**
*交易类型编码
*/
public java.lang.String vtrantypecode;
/**
*交易类型
*/
public java.lang.String ctrantypeid;
/**
*供应商分类
*/
public java.lang.String pk_supclass;
/**
*供应商
*/
public java.lang.String pk_supplier;
/**
*采购部门
*/
public java.lang.String pk_dept;
/**
*采购部门版本
*/
public java.lang.String pk_dept_v;
/**
*总数量
*/
public nc.vo.pub.lang.UFDouble ntotalnum;
/**
*总金额
*/
public nc.vo.pub.lang.UFDouble ntotalmny;
/**
*创建人
*/
public java.lang.String creator;
/**
*创建时间
*/
public UFDateTime creationtime;
/**
*最后修改人
*/
public java.lang.String modifier;
/**
*最后修改时间
*/
public UFDateTime modifiedtime;
/**
*审核人
*/
public java.lang.String vapproveid;
/**
*审核时间
*/
public UFDateTime tapprovetime;
/**
*审批批语
*/
public java.lang.String vapprovenote;
/**
*备注
*/
public java.lang.String vmemo;
/**
*自定义项1
*/
public java.lang.String vdef1;
/**
*自定义项2
*/
public java.lang.String vdef2;
/**
*自定义项3
*/
public java.lang.String vdef3;
/**
*自定义项4
*/
public java.lang.String vdef4;
/**
*自定义项5
*/
public java.lang.String vdef5;
/**
*自定义项6
*/
public java.lang.String vdef6;
/**
*自定义项7
*/
public java.lang.String vdef7;
/**
*自定义项8
*/
public java.lang.String vdef8;
/**
*自定义项9
*/
public java.lang.String vdef9;
/**
*自定义项10
*/
public java.lang.String vdef10;
/**
*自定义项11
*/
public java.lang.String vdef11;
/**
*自定义项12
*/
public java.lang.String vdef12;
/**
*自定义项13
*/
public java.lang.String vdef13;
/**
*自定义项14
*/
public java.lang.String vdef14;
/**
*自定义项15
*/
public java.lang.String vdef15;
/**
*自定义项16
*/
public java.lang.String vdef16;
/**
*自定义项17
*/
public java.lang.String vdef17;
/**
*自定义项18
*/
public java.lang.String vdef18;
/**
*自定义项19
*/
public java.lang.String vdef19;
/**
*自定义项20
*/
public java.lang.String vdef20;
/**
*时间戳
*/
public UFDateTime ts;
    
    
/**
* 属性 pk_order的Getter方法.属性名：主键
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getPk_order() {
return this.pk_order;
} 

/**
* 属性pk_order的Setter方法.属性名：主键
* 创建日期:2017-10-31
* @param newPk_order java.lang.String
*/
public void setPk_order ( java.lang.String pk_order) {
this.pk_order=pk_order;
} 
 
/**
* 属性 pk_group的Getter方法.属性名：集团
*  创建日期:2017-10-31
* @return nc.vo.org.GroupVO
*/
public java.lang.String getPk_group() {
return this.pk_group;
} 

/**
* 属性pk_group的Setter方法.属性名：集团
* 创建日期:2017-10-31
* @param newPk_group nc.vo.org.GroupVO
*/
public void setPk_group ( java.lang.String pk_group) {
this.pk_group=pk_group;
} 
 
/**
* 属性 pk_org的Getter方法.属性名：组织
*  创建日期:2017-10-31
* @return nc.vo.org.PurchaseOrgVO
*/
public java.lang.String getPk_org() {
return this.pk_org;
} 

/**
* 属性pk_org的Setter方法.属性名：组织
* 创建日期:2017-10-31
* @param newPk_org nc.vo.org.PurchaseOrgVO
*/
public void setPk_org ( java.lang.String pk_org) {
this.pk_org=pk_org;
} 
 
/**
* 属性 pk_org_v的Getter方法.属性名：组织多版本
*  创建日期:2017-10-31
* @return nc.vo.vorg.PurchaseOrgVersionVO
*/
public java.lang.String getPk_org_v() {
return this.pk_org_v;
} 

/**
* 属性pk_org_v的Setter方法.属性名：组织多版本
* 创建日期:2017-10-31
* @param newPk_org_v nc.vo.vorg.PurchaseOrgVersionVO
*/
public void setPk_org_v ( java.lang.String pk_org_v) {
this.pk_org_v=pk_org_v;
} 
 
/**
* 属性 vbillno的Getter方法.属性名：订单编号
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbillno() {
return this.vbillno;
} 

/**
* 属性vbillno的Setter方法.属性名：订单编号
* 创建日期:2017-10-31
* @param newVbillno java.lang.String
*/
public void setVbillno ( java.lang.String vbillno) {
this.vbillno=vbillno;
} 
 
/**
* 属性 dbilldate的Getter方法.属性名：订单日期
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDate
*/
public UFDate getDbilldate() {
return this.dbilldate;
} 

/**
* 属性dbilldate的Setter方法.属性名：订单日期
* 创建日期:2017-10-31
* @param newDbilldate nc.vo.pub.lang.UFDate
*/
public void setDbilldate ( UFDate dbilldate) {
this.dbilldate=dbilldate;
} 
 
/**
* 属性 vbillstatus的Getter方法.属性名：单据状态
*  创建日期:2017-10-31
* @return nc.vo.pub.pf.BillStatusEnum
*/
public java.lang.Integer getVbillstatus() {
return this.vbillstatus;
} 

/**
* 属性vbillstatus的Setter方法.属性名：单据状态
* 创建日期:2017-10-31
* @param newVbillstatus nc.vo.pub.pf.BillStatusEnum
*/
public void setVbillstatus ( java.lang.Integer vbillstatus) {
this.vbillstatus=vbillstatus;
} 
 
/**
* 属性 pk_billtypecode的Getter方法.属性名：单据类型编码
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getPk_billtypecode() {
return this.pk_billtypecode;
} 

/**
* 属性pk_billtypecode的Setter方法.属性名：单据类型编码
* 创建日期:2017-10-31
* @param newPk_billtypecode java.lang.String
*/
public void setPk_billtypecode ( java.lang.String pk_billtypecode) {
this.pk_billtypecode=pk_billtypecode;
} 
 
/**
* 属性 pk_billtypeid的Getter方法.属性名：单据类型
*  创建日期:2017-10-31
* @return nc.vo.pub.billtype.BilltypeVO
*/
public java.lang.String getPk_billtypeid() {
return this.pk_billtypeid;
} 

/**
* 属性pk_billtypeid的Setter方法.属性名：单据类型
* 创建日期:2017-10-31
* @param newPk_billtypeid nc.vo.pub.billtype.BilltypeVO
*/
public void setPk_billtypeid ( java.lang.String pk_billtypeid) {
this.pk_billtypeid=pk_billtypeid;
} 
 
/**
* 属性 pk_busitype的Getter方法.属性名：业务类型
*  创建日期:2017-10-31
* @return nc.vo.pub.billtype.BilltypeVO
*/
public java.lang.String getPk_busitype() {
return this.pk_busitype;
} 

/**
* 属性pk_busitype的Setter方法.属性名：业务类型
* 创建日期:2017-10-31
* @param newPk_busitype nc.vo.pub.billtype.BilltypeVO
*/
public void setPk_busitype ( java.lang.String pk_busitype) {
this.pk_busitype=pk_busitype;
} 
 
/**
* 属性 vtrantypecode的Getter方法.属性名：交易类型编码
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVtrantypecode() {
return this.vtrantypecode;
} 

/**
* 属性vtrantypecode的Setter方法.属性名：交易类型编码
* 创建日期:2017-10-31
* @param newVtrantypecode java.lang.String
*/
public void setVtrantypecode ( java.lang.String vtrantypecode) {
this.vtrantypecode=vtrantypecode;
} 
 
/**
* 属性 ctrantypeid的Getter方法.属性名：交易类型
*  创建日期:2017-10-31
* @return nc.vo.pub.billtype.BilltypeVO
*/
public java.lang.String getCtrantypeid() {
return this.ctrantypeid;
} 

/**
* 属性ctrantypeid的Setter方法.属性名：交易类型
* 创建日期:2017-10-31
* @param newCtrantypeid nc.vo.pub.billtype.BilltypeVO
*/
public void setCtrantypeid ( java.lang.String ctrantypeid) {
this.ctrantypeid=ctrantypeid;
} 
 
/**
* 属性 pk_supclass的Getter方法.属性名：供应商分类
*  创建日期:2017-10-31
* @return nc.vo.train.SupclassVO
*/
public java.lang.String getPk_supclass() {
return this.pk_supclass;
} 

/**
* 属性pk_supclass的Setter方法.属性名：供应商分类
* 创建日期:2017-10-31
* @param newPk_supclass nc.vo.train.SupclassVO
*/
public void setPk_supclass ( java.lang.String pk_supclass) {
this.pk_supclass=pk_supclass;
} 
 
/**
* 属性 pk_supplier的Getter方法.属性名：供应商
*  创建日期:2017-10-31
* @return nc.vo.train.SupplierVO
*/
public java.lang.String getPk_supplier() {
return this.pk_supplier;
} 

/**
* 属性pk_supplier的Setter方法.属性名：供应商
* 创建日期:2017-10-31
* @param newPk_supplier nc.vo.train.SupplierVO
*/
public void setPk_supplier ( java.lang.String pk_supplier) {
this.pk_supplier=pk_supplier;
} 
 
/**
* 属性 pk_dept的Getter方法.属性名：采购部门
*  创建日期:2017-10-31
* @return nc.vo.org.DeptVO
*/
public java.lang.String getPk_dept() {
return this.pk_dept;
} 

/**
* 属性pk_dept的Setter方法.属性名：采购部门
* 创建日期:2017-10-31
* @param newPk_dept nc.vo.org.DeptVO
*/
public void setPk_dept ( java.lang.String pk_dept) {
this.pk_dept=pk_dept;
} 
 
/**
* 属性 pk_dept_v的Getter方法.属性名：采购部门版本
*  创建日期:2017-10-31
* @return nc.vo.vorg.DeptVersionVO
*/
public java.lang.String getPk_dept_v() {
return this.pk_dept_v;
} 

/**
* 属性pk_dept_v的Setter方法.属性名：采购部门版本
* 创建日期:2017-10-31
* @param newPk_dept_v nc.vo.vorg.DeptVersionVO
*/
public void setPk_dept_v ( java.lang.String pk_dept_v) {
this.pk_dept_v=pk_dept_v;
} 
 
/**
* 属性 ntotalnum的Getter方法.属性名：总数量
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDouble
*/
public nc.vo.pub.lang.UFDouble getNtotalnum() {
return this.ntotalnum;
} 

/**
* 属性ntotalnum的Setter方法.属性名：总数量
* 创建日期:2017-10-31
* @param newNtotalnum nc.vo.pub.lang.UFDouble
*/
public void setNtotalnum ( nc.vo.pub.lang.UFDouble ntotalnum) {
this.ntotalnum=ntotalnum;
} 
 
/**
* 属性 ntotalmny的Getter方法.属性名：总金额
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDouble
*/
public nc.vo.pub.lang.UFDouble getNtotalmny() {
return this.ntotalmny;
} 

/**
* 属性ntotalmny的Setter方法.属性名：总金额
* 创建日期:2017-10-31
* @param newNtotalmny nc.vo.pub.lang.UFDouble
*/
public void setNtotalmny ( nc.vo.pub.lang.UFDouble ntotalmny) {
this.ntotalmny=ntotalmny;
} 
 
/**
* 属性 creator的Getter方法.属性名：创建人
*  创建日期:2017-10-31
* @return nc.vo.sm.UserVO
*/
public java.lang.String getCreator() {
return this.creator;
} 

/**
* 属性creator的Setter方法.属性名：创建人
* 创建日期:2017-10-31
* @param newCreator nc.vo.sm.UserVO
*/
public void setCreator ( java.lang.String creator) {
this.creator=creator;
} 
 
/**
* 属性 creationtime的Getter方法.属性名：创建时间
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDate
*/
public UFDateTime getCreationtime() {
return this.creationtime;
} 

/**
* 属性creationtime的Setter方法.属性名：创建时间
* 创建日期:2017-10-31
* @param newCreationtime nc.vo.pub.lang.UFDate
*/
public void setCreationtime ( UFDateTime creationtime) {
this.creationtime=creationtime;
} 
 
/**
* 属性 modifier的Getter方法.属性名：最后修改人
*  创建日期:2017-10-31
* @return nc.vo.sm.UserVO
*/
public java.lang.String getModifier() {
return this.modifier;
} 

/**
* 属性modifier的Setter方法.属性名：最后修改人
* 创建日期:2017-10-31
* @param newModifier nc.vo.sm.UserVO
*/
public void setModifier ( java.lang.String modifier) {
this.modifier=modifier;
} 
 
/**
* 属性 modifiedtime的Getter方法.属性名：最后修改时间
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDate
*/
public UFDateTime getModifiedtime() {
return this.modifiedtime;
} 

/**
* 属性modifiedtime的Setter方法.属性名：最后修改时间
* 创建日期:2017-10-31
* @param newModifiedtime nc.vo.pub.lang.UFDate
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.modifiedtime=modifiedtime;
} 
 
/**
* 属性 vapproveid的Getter方法.属性名：审核人
*  创建日期:2017-10-31
* @return nc.vo.sm.UserVO
*/
public java.lang.String getVapproveid() {
return this.vapproveid;
} 

/**
* 属性vapproveid的Setter方法.属性名：审核人
* 创建日期:2017-10-31
* @param newVapproveid nc.vo.sm.UserVO
*/
public void setVapproveid ( java.lang.String vapproveid) {
this.vapproveid=vapproveid;
} 
 
/**
* 属性 tapprovetime的Getter方法.属性名：审核时间
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDate
*/
public UFDateTime getTapprovetime() {
return this.tapprovetime;
} 

/**
* 属性tapprovetime的Setter方法.属性名：审核时间
* 创建日期:2017-10-31
* @param newTapprovetime nc.vo.pub.lang.UFDate
*/
public void setTapprovetime ( UFDateTime tapprovetime) {
this.tapprovetime=tapprovetime;
} 
 
/**
* 属性 vapprovenote的Getter方法.属性名：审批批语
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVapprovenote() {
return this.vapprovenote;
} 

/**
* 属性vapprovenote的Setter方法.属性名：审批批语
* 创建日期:2017-10-31
* @param newVapprovenote java.lang.String
*/
public void setVapprovenote ( java.lang.String vapprovenote) {
this.vapprovenote=vapprovenote;
} 
 
/**
* 属性 vmemo的Getter方法.属性名：备注
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVmemo() {
return this.vmemo;
} 

/**
* 属性vmemo的Setter方法.属性名：备注
* 创建日期:2017-10-31
* @param newVmemo java.lang.String
*/
public void setVmemo ( java.lang.String vmemo) {
this.vmemo=vmemo;
} 
 
/**
* 属性 vdef1的Getter方法.属性名：自定义项1
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef1() {
return this.vdef1;
} 

/**
* 属性vdef1的Setter方法.属性名：自定义项1
* 创建日期:2017-10-31
* @param newVdef1 java.lang.String
*/
public void setVdef1 ( java.lang.String vdef1) {
this.vdef1=vdef1;
} 
 
/**
* 属性 vdef2的Getter方法.属性名：自定义项2
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef2() {
return this.vdef2;
} 

/**
* 属性vdef2的Setter方法.属性名：自定义项2
* 创建日期:2017-10-31
* @param newVdef2 java.lang.String
*/
public void setVdef2 ( java.lang.String vdef2) {
this.vdef2=vdef2;
} 
 
/**
* 属性 vdef3的Getter方法.属性名：自定义项3
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef3() {
return this.vdef3;
} 

/**
* 属性vdef3的Setter方法.属性名：自定义项3
* 创建日期:2017-10-31
* @param newVdef3 java.lang.String
*/
public void setVdef3 ( java.lang.String vdef3) {
this.vdef3=vdef3;
} 
 
/**
* 属性 vdef4的Getter方法.属性名：自定义项4
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef4() {
return this.vdef4;
} 

/**
* 属性vdef4的Setter方法.属性名：自定义项4
* 创建日期:2017-10-31
* @param newVdef4 java.lang.String
*/
public void setVdef4 ( java.lang.String vdef4) {
this.vdef4=vdef4;
} 
 
/**
* 属性 vdef5的Getter方法.属性名：自定义项5
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef5() {
return this.vdef5;
} 

/**
* 属性vdef5的Setter方法.属性名：自定义项5
* 创建日期:2017-10-31
* @param newVdef5 java.lang.String
*/
public void setVdef5 ( java.lang.String vdef5) {
this.vdef5=vdef5;
} 
 
/**
* 属性 vdef6的Getter方法.属性名：自定义项6
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef6() {
return this.vdef6;
} 

/**
* 属性vdef6的Setter方法.属性名：自定义项6
* 创建日期:2017-10-31
* @param newVdef6 java.lang.String
*/
public void setVdef6 ( java.lang.String vdef6) {
this.vdef6=vdef6;
} 
 
/**
* 属性 vdef7的Getter方法.属性名：自定义项7
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef7() {
return this.vdef7;
} 

/**
* 属性vdef7的Setter方法.属性名：自定义项7
* 创建日期:2017-10-31
* @param newVdef7 java.lang.String
*/
public void setVdef7 ( java.lang.String vdef7) {
this.vdef7=vdef7;
} 
 
/**
* 属性 vdef8的Getter方法.属性名：自定义项8
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef8() {
return this.vdef8;
} 

/**
* 属性vdef8的Setter方法.属性名：自定义项8
* 创建日期:2017-10-31
* @param newVdef8 java.lang.String
*/
public void setVdef8 ( java.lang.String vdef8) {
this.vdef8=vdef8;
} 
 
/**
* 属性 vdef9的Getter方法.属性名：自定义项9
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef9() {
return this.vdef9;
} 

/**
* 属性vdef9的Setter方法.属性名：自定义项9
* 创建日期:2017-10-31
* @param newVdef9 java.lang.String
*/
public void setVdef9 ( java.lang.String vdef9) {
this.vdef9=vdef9;
} 
 
/**
* 属性 vdef10的Getter方法.属性名：自定义项10
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef10() {
return this.vdef10;
} 

/**
* 属性vdef10的Setter方法.属性名：自定义项10
* 创建日期:2017-10-31
* @param newVdef10 java.lang.String
*/
public void setVdef10 ( java.lang.String vdef10) {
this.vdef10=vdef10;
} 
 
/**
* 属性 vdef11的Getter方法.属性名：自定义项11
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef11() {
return this.vdef11;
} 

/**
* 属性vdef11的Setter方法.属性名：自定义项11
* 创建日期:2017-10-31
* @param newVdef11 java.lang.String
*/
public void setVdef11 ( java.lang.String vdef11) {
this.vdef11=vdef11;
} 
 
/**
* 属性 vdef12的Getter方法.属性名：自定义项12
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef12() {
return this.vdef12;
} 

/**
* 属性vdef12的Setter方法.属性名：自定义项12
* 创建日期:2017-10-31
* @param newVdef12 java.lang.String
*/
public void setVdef12 ( java.lang.String vdef12) {
this.vdef12=vdef12;
} 
 
/**
* 属性 vdef13的Getter方法.属性名：自定义项13
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef13() {
return this.vdef13;
} 

/**
* 属性vdef13的Setter方法.属性名：自定义项13
* 创建日期:2017-10-31
* @param newVdef13 java.lang.String
*/
public void setVdef13 ( java.lang.String vdef13) {
this.vdef13=vdef13;
} 
 
/**
* 属性 vdef14的Getter方法.属性名：自定义项14
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef14() {
return this.vdef14;
} 

/**
* 属性vdef14的Setter方法.属性名：自定义项14
* 创建日期:2017-10-31
* @param newVdef14 java.lang.String
*/
public void setVdef14 ( java.lang.String vdef14) {
this.vdef14=vdef14;
} 
 
/**
* 属性 vdef15的Getter方法.属性名：自定义项15
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef15() {
return this.vdef15;
} 

/**
* 属性vdef15的Setter方法.属性名：自定义项15
* 创建日期:2017-10-31
* @param newVdef15 java.lang.String
*/
public void setVdef15 ( java.lang.String vdef15) {
this.vdef15=vdef15;
} 
 
/**
* 属性 vdef16的Getter方法.属性名：自定义项16
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef16() {
return this.vdef16;
} 

/**
* 属性vdef16的Setter方法.属性名：自定义项16
* 创建日期:2017-10-31
* @param newVdef16 java.lang.String
*/
public void setVdef16 ( java.lang.String vdef16) {
this.vdef16=vdef16;
} 
 
/**
* 属性 vdef17的Getter方法.属性名：自定义项17
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef17() {
return this.vdef17;
} 

/**
* 属性vdef17的Setter方法.属性名：自定义项17
* 创建日期:2017-10-31
* @param newVdef17 java.lang.String
*/
public void setVdef17 ( java.lang.String vdef17) {
this.vdef17=vdef17;
} 
 
/**
* 属性 vdef18的Getter方法.属性名：自定义项18
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef18() {
return this.vdef18;
} 

/**
* 属性vdef18的Setter方法.属性名：自定义项18
* 创建日期:2017-10-31
* @param newVdef18 java.lang.String
*/
public void setVdef18 ( java.lang.String vdef18) {
this.vdef18=vdef18;
} 
 
/**
* 属性 vdef19的Getter方法.属性名：自定义项19
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef19() {
return this.vdef19;
} 

/**
* 属性vdef19的Setter方法.属性名：自定义项19
* 创建日期:2017-10-31
* @param newVdef19 java.lang.String
*/
public void setVdef19 ( java.lang.String vdef19) {
this.vdef19=vdef19;
} 
 
/**
* 属性 vdef20的Getter方法.属性名：自定义项20
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVdef20() {
return this.vdef20;
} 

/**
* 属性vdef20的Setter方法.属性名：自定义项20
* 创建日期:2017-10-31
* @param newVdef20 java.lang.String
*/
public void setVdef20 ( java.lang.String vdef20) {
this.vdef20=vdef20;
} 
 
/**
* 属性 生成时间戳的Getter方法.属性名：时间戳
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDateTime
*/
public UFDateTime getTs() {
return this.ts;
}
/**
* 属性生成时间戳的Setter方法.属性名：时间戳
* 创建日期:2017-10-31
* @param newts nc.vo.pub.lang.UFDateTime
*/
public void setTs(UFDateTime ts){
this.ts=ts;
} 
     
    @Override
    public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("train.orders");
    }
   }
    