drop table pub_apiplat_trans cascade constraints;

/*==============================================================*/
/* Table: pub_apiplat_trans                                     */
/*==============================================================*/
create table pub_apiplat_trans 
(
   pk_apiplat_trans     CHAR(20)             not null,
   ext_code             varchar2(150),
   ext_name             varchar2(150),
   ext_bill_code        varchar2(150),
   ext_bill_name        varchar2(150),
   default_trans_rule   varchar2(150),
   trans_style          varchar2(150),
   nc_bill_type         CHAR(20),
   ts                   CHAR(19),
   constraint PK_PUB_APIPLAT_TRANS primary key (pk_apiplat_trans)
);

drop table pub_apiplat_trans_b cascade constraints;

-- Create table
create table PUB_APIPLAT_TRANS_B
(
  pk_apiplat_trans_b CHAR(20) not null,
  pk_apiplat_trans   CHAR(20),
  nc_field_code      VARCHAR2(150),
  nc_field_name      VARCHAR2(150),
  nc_field_isrequire VARCHAR2(150),
  trans_logic_style  VARCHAR2(150),
  trans_rule         VARCHAR2(150),
  trans_sql          VARCHAR2(800),
  ext_field_code     VARCHAR2(150),
  ext_field_name     VARCHAR2(150),
  ts                 CHAR(19),
  name_refinfo       VARCHAR2(150),
  code_refinfo       VARCHAR2(150)
)
tablespace NNC_DATA01
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 512K
    next 512K
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table PUB_APIPLAT_TRANS_B
  add constraint PK_PUB_APIPLAT_TRANS_B primary key (PK_APIPLAT_TRANS_B)
  using index 
  tablespace NNC_DATA01
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 512K
    next 512K
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
