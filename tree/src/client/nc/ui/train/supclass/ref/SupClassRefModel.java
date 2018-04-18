package nc.ui.train.supclass.ref;

import nc.ui.bd.ref.AbstractRefTreeModel;

/**
 * ��Ӧ�̷������β���
 * 
 * @author shidalin
 * 
 */
public class SupClassRefModel extends AbstractRefTreeModel {

	public SupClassRefModel() {
		super();
	}

	@Override
	public int getClassDefaultFieldCount() {
		return super.getClassDefaultFieldCount();
	}

	@Override
	public String[] getFieldCode() {// �������ݵ��ֶα���
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getFieldName() {// �������ݵ��ֶ�����
		return new String[] { "��Ӧ�̷������", "��Ӧ�̷�������" };
	}

	@Override
	public String[] getHiddenFieldCode() {// ��Ҫ���صĲ������ݵ��ֶα���
		// ��Ҫ���漰�������õ��ֶη��룬������getFieldCode�е��ֶ�
		// ����˴���Ӧ�ý�getFatherField�����е��ֶκ�getChildField�����е��ֶη���
		return new String[] { "pk_supclass", "parent_id" };
	}

	@Override
	public String getTableName() {// �������ݵı���
		return "tr_supclass";
	}

	@Override
	public String getPkFieldCode() {// �������ݶ�Ӧ�������
		return "pk_supclass";
	}

	@Override
	public String getFatherField() {// ���ṹ�ĸ������ֶ�
		return "parent_id";
	}

	@Override
	public String getChildField() {// ���ṹ���������ֶ�
		return "pk_supclass";
	}

	@Override
	public String getRefCodeField() {// ���ն�Ӧ�ı����ֶ�
		return "code";
	}

	@Override
	public String getRefNameField() {// ���ն�Ӧ�������ֶ�
		return "name";
	}

	@Override
	public String getWherePart() {// �������ݵĹ�������
	// return super.getWherePart();
		String wherePart = super.getWherePart();
		if (null == wherePart || "".equals(wherePart.trim())) {
			wherePart = " nvl(dr,0) = 0 ";
		} else {
			wherePart += " and nvl(dr,0) = 0 ";
		}
		return wherePart;
	}

}
