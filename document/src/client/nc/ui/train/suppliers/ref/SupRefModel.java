package nc.ui.train.suppliers.ref;

import nc.ui.bd.ref.AbstractRefGridTreeModel;

/**
 * ��Ӧ�̻�������-�����Ͳ���
 * 
 * @author shidalin
 * 
 */
public class SupRefModel extends AbstractRefGridTreeModel {

	public SupRefModel() {
		super();
	}

	@Override
	public int getClassDefaultFieldCount() {
		return super.getClassDefaultFieldCount();
	}

	@Override
	public String[] getClassFieldCode() {// ���ṹ���ֶα���
		return new String[] { "code", "name", "parent_id", "pk_supclass" };
	}

	@Override
	public String getClassTableName() {// ���ṹ�ı���
		return "tr_supclass";
	}

	@Override
	public String getClassFatherField() {// ���ṹ�ĸ������ֶ�
		return "parent_id";
	}

	@Override
	public String getClassChildField() {// ���ṹ���������ֶ�
		return "pk_supclass";
	}

	@Override
	public String getClassWherePart() {// ���ṹ�Ĺ�������
		String wherePart = super.getClassWherePart();
		if (null == wherePart || "".equals(wherePart.trim())) {
			wherePart = " nvl(dr,0) = 0 ";
		} else {
			wherePart += " and nvl(dr,0) = 0 ";
		}
		return wherePart;
	}

	@Override
	public String getClassJoinField() {// ���ṹ�����ͱ�������ֶ�
		return "pk_supclass";
	}

	@Override
	public String getDocJoinField() {// �����ݣ����ͱ�������ֶ�
		return "pk_supclass";
	}

	@Override
	public String[] getFieldCode() {// �����ݵ��ֶα���
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getFieldName() {// �����ݵ��ֶ�����
		return new String[] { "��Ӧ�̱���", "��Ӧ������" };
	}

	@Override
	public String[] getHiddenFieldCode() {// ��������Ҫ���ص��ֶα���
		return new String[] { "pk_supplier", "pk_supclass" };
	}

	@Override
	public String getTableName() {// �����ݵı���
		return "tr_supplier";
	}

	@Override
	public String getPkFieldCode() {// �����ݵ������ֶ�
		return "pk_supplier";
	}

	@Override
	public String getRefCodeField() {// �����ݵĲ��ձ����ֶ�
		return "code";
	}

	@Override
	public String getRefNameField() {// �����ݵĲ��������ֶ�
		return "name";
	}

	@Override
	public String getWherePart() {// �����ݵĹ�������
		String wherePart = super.getWherePart();
		if (null == wherePart || "".equals(wherePart.trim())) {
			wherePart = " nvl(dr,0) = 0 ";
		} else {
			wherePart += " and nvl(dr,0) = 0 ";
		}
		return wherePart;
	}

}
