DELETE FROM pub_bcr_candiattr WHERE pk_nbcr = '0001ZZ100000000077HD';
DELETE FROM pub_bcr_elem WHERE pk_billcodebase in ( select pk_billcodebase from pub_bcr_RuleBase where nbcrcode = 'TR03' );
DELETE FROM pub_bcr_RuleBase WHERE nbcrcode = 'TR03';
DELETE FROM pub_bcr_nbcr WHERE pk_nbcr = '0001ZZ100000000077HD';
DELETE FROM pub_bcr_OrgRela WHERE pk_billcodebase = '0001ZZ100000000077HE';
DELETE FROM pub_bcr_RuleBase WHERE pk_billcodebase = '0001ZZ100000000077HE';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ100000000077HF';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ100000000077HG';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ100000000077HH';
DELETE FROM bd_billtype2 WHERE pk_billtypeid = '0001ZZ100000000077H8';
DELETE FROM bd_fwdbilltype WHERE pk_billtypeid = '0001ZZ100000000077H8';
DELETE FROM pub_function WHERE pk_billtype = 'TR03';
DELETE FROM pub_billaction WHERE pk_billtypeid = '0001ZZ100000000077H8';
DELETE FROM pub_billactiongroup WHERE pk_billtype = 'TR03';
DELETE FROM bd_billtype WHERE pk_billtypeid = '0001ZZ100000000077H8';
delete from temppkts;
DELETE FROM sm_rule_type WHERE pk_rule_type = null;
DELETE FROM sm_permission_res WHERE pk_permission_res = null;
DELETE FROM pub_billaction WHERE pk_billaction = '0001ZZ100000000077H9';
DELETE FROM pub_billaction WHERE pk_billaction = '0001ZZ100000000077HA';
DELETE FROM pub_busiclass WHERE pk_busiclass = '0001ZZ100000000077HB';
DELETE FROM pub_busiclass WHERE pk_busiclass = '0001ZZ100000000077HC';
DELETE FROM pub_systemplate_base where pk_systemplate = '0001ZZ100000000077H7';
delete from pub_print_datasource where ctemplateid = '0001ZZ100000000077CI';
delete from pub_print_cell where ctemplateid = '0001ZZ100000000077CI';
delete from pub_print_line where ctemplateid = '0001ZZ100000000077CI';
delete from pub_print_variable where ctemplateid = '0001ZZ100000000077CI';
delete from pub_print_template where ctemplateid = '0001ZZ100000000077CI';
DELETE FROM pub_systemplate_base where pk_systemplate = '0001ZZ100000000077CH';
delete from pub_query_condition where pk_templet = '0001ZZ100000000077BH';
delete from pub_query_templet where id = '0001ZZ100000000077BH';
DELETE FROM pub_systemplate_base where pk_systemplate = '0001ZZ100000000077BG';
delete from pub_billtemplet_b where pk_billtemplet = '0001ZZ1000000000779G';
delete from pub_billtemplet where pk_billtemplet = '0001ZZ1000000000779G';
DELETE FROM pub_billtemplet_t WHERE pk_billtemplet = '0001ZZ1000000000779G';
DELETE FROM sm_menuitemreg WHERE pk_menuitem = '0001ZZ1000000000779F';
DELETE FROM sm_funcregister WHERE cfunid = '0001ZZ1000000000779D';
DELETE FROM sm_paramregister WHERE pk_param = '0001ZZ1000000000779E';
