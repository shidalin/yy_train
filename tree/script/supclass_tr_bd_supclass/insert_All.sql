INSERT INTO sm_funcregister (ts, funtype, isbuttonpower, fun_name, funcode, isenable, iscauserusable, class_name, fun_desc, fun_property, isfunctype, orgtypecode, cfunid, help_name, pk_group, mdid, parent_id, dr, own_module ) VALUES ('2017-10-31 13:22:08', 0, 'N', '供应商分类', 'TR010201', 'Y', null, 'nc.ui.pubapp.uif2app.ToftPanelAdaptorEx', null, 0, 'N', 'PURCHASEORGTYPE00000', '0001ZZ10000000007146', null, '~', '~', '1001ZZ10000000006PIJ', 0, 'TR01' );
INSERT INTO sm_paramregister (ts, paramname, pk_param, parentid, paramvalue, dr ) VALUES ('2017-10-31 13:22:08', 'BeanConfigFilePath', '0001ZZ10000000007147', '0001ZZ10000000007146', 'nc/ui/train/supclass/ace/view/Supclass_config.xml', 0 );
INSERT INTO sm_menuitemreg (ts, nodeorder, pk_menu, menuitemname, iconpath, resid, pk_menuitem, ismenutype, menudes, funcode, menuitemcode, dr ) VALUES ('2017-10-31 13:22:08', null, '1004ZZ10000000000FFL', '供应商分类', null, 'DTR010201', '0001ZZ10000000007148', 'N', null, 'TR010201', 'TR010201', 0 );
INSERT INTO pub_billtemplet (ts, BILL_TEMPLETCAPTION, BILL_TEMPLETNAME, NODECODE, PK_BILLTEMPLET, PK_BILLTYPECODE, PK_CORP, METADATACLASS, MODULECODE, LAYER ) VALUES ('2017-10-31 13:22:09', '供应商分类', 'SYSTEM', 'TR010201', '0001ZZ10000000007149', 'TR010201', '@@@@', 'train.supclass', 'TR01', 0 );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'pk_supclass', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714A', 0, 'N', 'N', 0, 1, 1, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.pk_supclass', 'pk_supclass', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'pk_group', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714B', 0, 'N', 'N', 1, 2, 2, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.pk_group', 'pk_group', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'pk_org', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714C', 0, 'N', 'N', 1, 3, 3, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.pk_org', 'pk_org', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'pk_org_v', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714D', 0, 'N', 'N', 1, 4, 4, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.pk_org_v', 'pk_org_v', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'code', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714E', 0, 'N', 'N', 1, 5, 5, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.code', 'code', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'name', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714F', 0, 'N', 'N', 1, 6, 6, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.name', 'name', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'parent_id', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714G', 0, 'N', 'N', 1, 7, 7, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.parent_id', 'parent_id', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'creator', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714H', 0, 'N', 'N', 1, 8, 8, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.creator', 'creator', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'creationtime', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714I', 0, 'N', 'N', 1, 9, 9, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.creationtime', 'creationtime', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'modifier', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714J', 0, 'N', 'N', 1, 10, 10, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.modifier', 'modifier', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'modifiedtime', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714K', 0, 'N', 'N', 1, 11, 11, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.modifiedtime', 'modifiedtime', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vmemo', 'N', 1, 'Y', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714L', 0, 'N', 'N', 1, 12, 12, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vmemo', 'vmemo', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef1', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714M', 0, 'N', 'N', 0, 13, 13, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef1', 'vdef1', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef2', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714N', 0, 'N', 'N', 0, 14, 14, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef2', 'vdef2', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef3', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714O', 0, 'N', 'N', 0, 15, 15, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef3', 'vdef3', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef4', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714P', 0, 'N', 'N', 0, 16, 16, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef4', 'vdef4', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef5', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714Q', 0, 'N', 'N', 0, 17, 17, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef5', 'vdef5', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef6', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714R', 0, 'N', 'N', 0, 18, 18, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef6', 'vdef6', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef7', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714S', 0, 'N', 'N', 0, 19, 19, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef7', 'vdef7', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef8', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714T', 0, 'N', 'N', 0, 20, 20, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef8', 'vdef8', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef9', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714U', 0, 'N', 'N', 0, 21, 21, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef9', 'vdef9', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef10', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714V', 0, 'N', 'N', 0, 22, 22, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef10', 'vdef10', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef11', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714W', 0, 'N', 'N', 0, 23, 23, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef11', 'vdef11', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef12', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714X', 0, 'N', 'N', 0, 24, 24, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef12', 'vdef12', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef13', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714Y', 0, 'N', 'N', 0, 25, 25, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef13', 'vdef13', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef14', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ1000000000714Z', 0, 'N', 'N', 0, 26, 26, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef14', 'vdef14', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef15', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007150', 0, 'N', 'N', 0, 27, 27, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef15', 'vdef15', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef16', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007151', 0, 'N', 'N', 0, 28, 28, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef16', 'vdef16', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef17', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007152', 0, 'N', 'N', 0, 29, 29, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef17', 'vdef17', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef18', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007153', 0, 'N', 'N', 0, 30, 30, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef18', 'vdef18', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef19', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007154', 0, 'N', 'N', 0, 31, 31, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef19', 'vdef19', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'vdef20', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007155', 0, 'N', 'N', 0, 32, 32, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.vdef20', 'vdef20', 'N', 'N' );
INSERT INTO pub_billtemplet_b (ts, CARDFLAG, DATATYPE, EDITFLAG, FOREGROUND, INPUTLENGTH, ITEMKEY, LEAFFLAG, LISTFLAG, LISTSHOWFLAG, LOCKFLAG, NEWLINEFLAG, NULLFLAG, PK_BILLTEMPLET, PK_BILLTEMPLET_B, POS, REVISEFLAG, USERREVISEFLAG, SHOWFLAG, SHOWORDER, LISTSHOWORDER, TABLE_CODE, TABLE_NAME, TOTALFLAG, USERDEFFLAG, USEREDITFLAG, USERFLAG, USERSHOWFLAG, WIDTH, METADATAPROPERTY, METADATAPATH, HYPERLINKFLAG, LISTHYPERLINKFLAG ) VALUES ('2017-10-31 13:22:09', 1, -1, 1, -1, -1, 'ts', 'N', 1, 'N', 0, 'N', 0, '0001ZZ10000000007149', '0001ZZ10000000007156', 0, 'N', 'N', 0, 33, 33, 'supclass', '供应商分类', 0, 'N', 1, 1, 1, 1, 'train.supclass.ts', 'ts', 'N', 'N' );
INSERT INTO pub_billtemplet_t (ts, position, resid, tabindex, vdef2, vdef1, pk_billtemplet_t, tabcode, metadatapath, vdef3, pos, pk_billtemplet, metadataclass, basetab, mixindex, tabname, pk_layout ) VALUES ('2017-10-31 13:22:09', null, null, 0, null, null, '0001ZZ10000000007157', 'supclass', 'supclass', null, 0, '0001ZZ10000000007149', 'train.supclass', null, null, '供应商分类', '~' );
INSERT INTO pub_systemplate_base (ts, nodekey, funnode, layer, moduleid, templateid, pk_systemplate, devorg, pk_country, pk_industry, tempstyle, dr ) VALUES ('2017-10-31 13:22:09', 'bt', 'TR010201', 0, 'TR01', '0001ZZ10000000007149', '0001ZZ10000000007158', '00001', '~', '~', 0, 0 );
