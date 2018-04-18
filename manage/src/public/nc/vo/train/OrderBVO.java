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
 
public class OrderBVO extends SuperVO {
	
/**
*主键
*/
public java.lang.String pk_order_b;
/**
*主表主键
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
*行号
*/
public java.lang.String crowno;
/**
*物料编码
*/
public java.lang.String pk_material;
/**
*数量
*/
public nc.vo.pub.lang.UFDouble nnum;
/**
*单价
*/
public nc.vo.pub.lang.UFDouble nprice;
/**
*金额
*/
public nc.vo.pub.lang.UFDouble nmny;
/**
*备注
*/
public java.lang.String vmemo;
/**
*自定义项1
*/
public java.lang.String vbdef1;
/**
*自定义项2
*/
public java.lang.String vbdef2;
/**
*自定义项3
*/
public java.lang.String vbdef3;
/**
*自定义项4
*/
public java.lang.String vbdef4;
/**
*自定义项5
*/
public java.lang.String vbdef5;
/**
*自定义项6
*/
public java.lang.String vbdef6;
/**
*自定义项7
*/
public java.lang.String vbdef7;
/**
*自定义项8
*/
public java.lang.String vbdef8;
/**
*自定义项9
*/
public java.lang.String vbdef9;
/**
*自定义项10
*/
public java.lang.String vbdef10;
/**
*自定义项11
*/
public java.lang.String vbdef11;
/**
*自定义项12
*/
public java.lang.String vbdef12;
/**
*自定义项13
*/
public java.lang.String vbdef13;
/**
*自定义项14
*/
public java.lang.String vbdef14;
/**
*自定义项15
*/
public java.lang.String vbdef15;
/**
*自定义项16
*/
public java.lang.String vbdef16;
/**
*自定义项17
*/
public java.lang.String vbdef17;
/**
*自定义项18
*/
public java.lang.String vbdef18;
/**
*自定义项19
*/
public java.lang.String vbdef19;
/**
*自定义项20
*/
public java.lang.String vbdef20;
/**
*时间戳
*/
public UFDateTime ts;
    
    
/**
* 属性 pk_order_b的Getter方法.属性名：主键
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getPk_order_b() {
return this.pk_order_b;
} 

/**
* 属性pk_order_b的Setter方法.属性名：主键
* 创建日期:2017-10-31
* @param newPk_order_b java.lang.String
*/
public void setPk_order_b ( java.lang.String pk_order_b) {
this.pk_order_b=pk_order_b;
} 
 
/**
* 属性 pk_order的Getter方法.属性名：主表主键
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getPk_order() {
return this.pk_order;
} 

/**
* 属性pk_order的Setter方法.属性名：主表主键
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
* @return nc.vo.org.DeptVO
*/
public java.lang.String getPk_org() {
return this.pk_org;
} 

/**
* 属性pk_org的Setter方法.属性名：组织
* 创建日期:2017-10-31
* @param newPk_org nc.vo.org.DeptVO
*/
public void setPk_org ( java.lang.String pk_org) {
this.pk_org=pk_org;
} 
 
/**
* 属性 pk_org_v的Getter方法.属性名：组织多版本
*  创建日期:2017-10-31
* @return nc.vo.vorg.DeptVersionVO
*/
public java.lang.String getPk_org_v() {
return this.pk_org_v;
} 

/**
* 属性pk_org_v的Setter方法.属性名：组织多版本
* 创建日期:2017-10-31
* @param newPk_org_v nc.vo.vorg.DeptVersionVO
*/
public void setPk_org_v ( java.lang.String pk_org_v) {
this.pk_org_v=pk_org_v;
} 
 
/**
* 属性 crowno的Getter方法.属性名：行号
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getCrowno() {
return this.crowno;
} 

/**
* 属性crowno的Setter方法.属性名：行号
* 创建日期:2017-10-31
* @param newCrowno java.lang.String
*/
public void setCrowno ( java.lang.String crowno) {
this.crowno=crowno;
} 
 
/**
* 属性 pk_material的Getter方法.属性名：物料编码
*  创建日期:2017-10-31
* @return nc.vo.bd.material.MaterialVersionVO
*/
public java.lang.String getPk_material() {
return this.pk_material;
} 

/**
* 属性pk_material的Setter方法.属性名：物料编码
* 创建日期:2017-10-31
* @param newPk_material nc.vo.bd.material.MaterialVersionVO
*/
public void setPk_material ( java.lang.String pk_material) {
this.pk_material=pk_material;
} 
 
/**
* 属性 nnum的Getter方法.属性名：数量
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDouble
*/
public nc.vo.pub.lang.UFDouble getNnum() {
return this.nnum;
} 

/**
* 属性nnum的Setter方法.属性名：数量
* 创建日期:2017-10-31
* @param newNnum nc.vo.pub.lang.UFDouble
*/
public void setNnum ( nc.vo.pub.lang.UFDouble nnum) {
this.nnum=nnum;
} 
 
/**
* 属性 nprice的Getter方法.属性名：单价
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDouble
*/
public nc.vo.pub.lang.UFDouble getNprice() {
return this.nprice;
} 

/**
* 属性nprice的Setter方法.属性名：单价
* 创建日期:2017-10-31
* @param newNprice nc.vo.pub.lang.UFDouble
*/
public void setNprice ( nc.vo.pub.lang.UFDouble nprice) {
this.nprice=nprice;
} 
 
/**
* 属性 nmny的Getter方法.属性名：金额
*  创建日期:2017-10-31
* @return nc.vo.pub.lang.UFDouble
*/
public nc.vo.pub.lang.UFDouble getNmny() {
return this.nmny;
} 

/**
* 属性nmny的Setter方法.属性名：金额
* 创建日期:2017-10-31
* @param newNmny nc.vo.pub.lang.UFDouble
*/
public void setNmny ( nc.vo.pub.lang.UFDouble nmny) {
this.nmny=nmny;
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
* 属性 vbdef1的Getter方法.属性名：自定义项1
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef1() {
return this.vbdef1;
} 

/**
* 属性vbdef1的Setter方法.属性名：自定义项1
* 创建日期:2017-10-31
* @param newVbdef1 java.lang.String
*/
public void setVbdef1 ( java.lang.String vbdef1) {
this.vbdef1=vbdef1;
} 
 
/**
* 属性 vbdef2的Getter方法.属性名：自定义项2
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef2() {
return this.vbdef2;
} 

/**
* 属性vbdef2的Setter方法.属性名：自定义项2
* 创建日期:2017-10-31
* @param newVbdef2 java.lang.String
*/
public void setVbdef2 ( java.lang.String vbdef2) {
this.vbdef2=vbdef2;
} 
 
/**
* 属性 vbdef3的Getter方法.属性名：自定义项3
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef3() {
return this.vbdef3;
} 

/**
* 属性vbdef3的Setter方法.属性名：自定义项3
* 创建日期:2017-10-31
* @param newVbdef3 java.lang.String
*/
public void setVbdef3 ( java.lang.String vbdef3) {
this.vbdef3=vbdef3;
} 
 
/**
* 属性 vbdef4的Getter方法.属性名：自定义项4
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef4() {
return this.vbdef4;
} 

/**
* 属性vbdef4的Setter方法.属性名：自定义项4
* 创建日期:2017-10-31
* @param newVbdef4 java.lang.String
*/
public void setVbdef4 ( java.lang.String vbdef4) {
this.vbdef4=vbdef4;
} 
 
/**
* 属性 vbdef5的Getter方法.属性名：自定义项5
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef5() {
return this.vbdef5;
} 

/**
* 属性vbdef5的Setter方法.属性名：自定义项5
* 创建日期:2017-10-31
* @param newVbdef5 java.lang.String
*/
public void setVbdef5 ( java.lang.String vbdef5) {
this.vbdef5=vbdef5;
} 
 
/**
* 属性 vbdef6的Getter方法.属性名：自定义项6
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef6() {
return this.vbdef6;
} 

/**
* 属性vbdef6的Setter方法.属性名：自定义项6
* 创建日期:2017-10-31
* @param newVbdef6 java.lang.String
*/
public void setVbdef6 ( java.lang.String vbdef6) {
this.vbdef6=vbdef6;
} 
 
/**
* 属性 vbdef7的Getter方法.属性名：自定义项7
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef7() {
return this.vbdef7;
} 

/**
* 属性vbdef7的Setter方法.属性名：自定义项7
* 创建日期:2017-10-31
* @param newVbdef7 java.lang.String
*/
public void setVbdef7 ( java.lang.String vbdef7) {
this.vbdef7=vbdef7;
} 
 
/**
* 属性 vbdef8的Getter方法.属性名：自定义项8
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef8() {
return this.vbdef8;
} 

/**
* 属性vbdef8的Setter方法.属性名：自定义项8
* 创建日期:2017-10-31
* @param newVbdef8 java.lang.String
*/
public void setVbdef8 ( java.lang.String vbdef8) {
this.vbdef8=vbdef8;
} 
 
/**
* 属性 vbdef9的Getter方法.属性名：自定义项9
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef9() {
return this.vbdef9;
} 

/**
* 属性vbdef9的Setter方法.属性名：自定义项9
* 创建日期:2017-10-31
* @param newVbdef9 java.lang.String
*/
public void setVbdef9 ( java.lang.String vbdef9) {
this.vbdef9=vbdef9;
} 
 
/**
* 属性 vbdef10的Getter方法.属性名：自定义项10
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef10() {
return this.vbdef10;
} 

/**
* 属性vbdef10的Setter方法.属性名：自定义项10
* 创建日期:2017-10-31
* @param newVbdef10 java.lang.String
*/
public void setVbdef10 ( java.lang.String vbdef10) {
this.vbdef10=vbdef10;
} 
 
/**
* 属性 vbdef11的Getter方法.属性名：自定义项11
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef11() {
return this.vbdef11;
} 

/**
* 属性vbdef11的Setter方法.属性名：自定义项11
* 创建日期:2017-10-31
* @param newVbdef11 java.lang.String
*/
public void setVbdef11 ( java.lang.String vbdef11) {
this.vbdef11=vbdef11;
} 
 
/**
* 属性 vbdef12的Getter方法.属性名：自定义项12
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef12() {
return this.vbdef12;
} 

/**
* 属性vbdef12的Setter方法.属性名：自定义项12
* 创建日期:2017-10-31
* @param newVbdef12 java.lang.String
*/
public void setVbdef12 ( java.lang.String vbdef12) {
this.vbdef12=vbdef12;
} 
 
/**
* 属性 vbdef13的Getter方法.属性名：自定义项13
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef13() {
return this.vbdef13;
} 

/**
* 属性vbdef13的Setter方法.属性名：自定义项13
* 创建日期:2017-10-31
* @param newVbdef13 java.lang.String
*/
public void setVbdef13 ( java.lang.String vbdef13) {
this.vbdef13=vbdef13;
} 
 
/**
* 属性 vbdef14的Getter方法.属性名：自定义项14
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef14() {
return this.vbdef14;
} 

/**
* 属性vbdef14的Setter方法.属性名：自定义项14
* 创建日期:2017-10-31
* @param newVbdef14 java.lang.String
*/
public void setVbdef14 ( java.lang.String vbdef14) {
this.vbdef14=vbdef14;
} 
 
/**
* 属性 vbdef15的Getter方法.属性名：自定义项15
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef15() {
return this.vbdef15;
} 

/**
* 属性vbdef15的Setter方法.属性名：自定义项15
* 创建日期:2017-10-31
* @param newVbdef15 java.lang.String
*/
public void setVbdef15 ( java.lang.String vbdef15) {
this.vbdef15=vbdef15;
} 
 
/**
* 属性 vbdef16的Getter方法.属性名：自定义项16
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef16() {
return this.vbdef16;
} 

/**
* 属性vbdef16的Setter方法.属性名：自定义项16
* 创建日期:2017-10-31
* @param newVbdef16 java.lang.String
*/
public void setVbdef16 ( java.lang.String vbdef16) {
this.vbdef16=vbdef16;
} 
 
/**
* 属性 vbdef17的Getter方法.属性名：自定义项17
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef17() {
return this.vbdef17;
} 

/**
* 属性vbdef17的Setter方法.属性名：自定义项17
* 创建日期:2017-10-31
* @param newVbdef17 java.lang.String
*/
public void setVbdef17 ( java.lang.String vbdef17) {
this.vbdef17=vbdef17;
} 
 
/**
* 属性 vbdef18的Getter方法.属性名：自定义项18
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef18() {
return this.vbdef18;
} 

/**
* 属性vbdef18的Setter方法.属性名：自定义项18
* 创建日期:2017-10-31
* @param newVbdef18 java.lang.String
*/
public void setVbdef18 ( java.lang.String vbdef18) {
this.vbdef18=vbdef18;
} 
 
/**
* 属性 vbdef19的Getter方法.属性名：自定义项19
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef19() {
return this.vbdef19;
} 

/**
* 属性vbdef19的Setter方法.属性名：自定义项19
* 创建日期:2017-10-31
* @param newVbdef19 java.lang.String
*/
public void setVbdef19 ( java.lang.String vbdef19) {
this.vbdef19=vbdef19;
} 
 
/**
* 属性 vbdef20的Getter方法.属性名：自定义项20
*  创建日期:2017-10-31
* @return java.lang.String
*/
public java.lang.String getVbdef20() {
return this.vbdef20;
} 

/**
* 属性vbdef20的Setter方法.属性名：自定义项20
* 创建日期:2017-10-31
* @param newVbdef20 java.lang.String
*/
public void setVbdef20 ( java.lang.String vbdef20) {
this.vbdef20=vbdef20;
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
    return VOMetaFactory.getInstance().getVOMeta("train.orderItem");
    }
   }
    