DELETE FROM pub_bcr_candiattr WHERE pk_nbcr = '0001ZZ10000000007G53';
DELETE FROM pub_bcr_elem WHERE pk_billcodebase in ( select pk_billcodebase from pub_bcr_RuleBase where nbcrcode = 'TR05' );
DELETE FROM pub_bcr_RuleBase WHERE nbcrcode = 'TR05';
DELETE FROM pub_bcr_nbcr WHERE pk_nbcr = '0001ZZ10000000007G53';
DELETE FROM pub_bcr_OrgRela WHERE pk_billcodebase = '0001ZZ10000000007G54';
DELETE FROM pub_bcr_RuleBase WHERE pk_billcodebase = '0001ZZ10000000007G54';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ10000000007G55';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ10000000007G56';
DELETE FROM pub_bcr_elem WHERE pk_billcodeelem = '0001ZZ10000000007G57';
