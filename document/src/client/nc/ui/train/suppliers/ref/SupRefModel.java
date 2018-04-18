package nc.ui.train.suppliers.ref;

import nc.ui.bd.ref.AbstractRefGridTreeModel;

/**
 * 供应商基本档案-树表型参照
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
	public String[] getClassFieldCode() {// 树结构的字段编码
		return new String[] { "code", "name", "parent_id", "pk_supclass" };
	}

	@Override
	public String getClassTableName() {// 树结构的表名
		return "tr_supclass";
	}

	@Override
	public String getClassFatherField() {// 树结构的父主键字段
		return "parent_id";
	}

	@Override
	public String getClassChildField() {// 树结构的子主键字段
		return "pk_supclass";
	}

	@Override
	public String getClassWherePart() {// 树结构的过滤条件
		String wherePart = super.getClassWherePart();
		if (null == wherePart || "".equals(wherePart.trim())) {
			wherePart = " nvl(dr,0) = 0 ";
		} else {
			wherePart += " and nvl(dr,0) = 0 ";
		}
		return wherePart;
	}

	@Override
	public String getClassJoinField() {// 树结构：树和表关联的字段
		return "pk_supclass";
	}

	@Override
	public String getDocJoinField() {// 表数据：树和表关联的字段
		return "pk_supclass";
	}

	@Override
	public String[] getFieldCode() {// 表数据的字段编码
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getFieldName() {// 表数据的字段名称
		return new String[] { "供应商编码", "供应商名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {// 表数据需要隐藏的字段编码
		return new String[] { "pk_supplier", "pk_supclass" };
	}

	@Override
	public String getTableName() {// 表数据的表名
		return "tr_supplier";
	}

	@Override
	public String getPkFieldCode() {// 表数据的主键字段
		return "pk_supplier";
	}

	@Override
	public String getRefCodeField() {// 表数据的参照编码字段
		return "code";
	}

	@Override
	public String getRefNameField() {// 表数据的参照名称字段
		return "name";
	}

	@Override
	public String getWherePart() {// 表数据的过滤条件
		String wherePart = super.getWherePart();
		if (null == wherePart || "".equals(wherePart.trim())) {
			wherePart = " nvl(dr,0) = 0 ";
		} else {
			wherePart += " and nvl(dr,0) = 0 ";
		}
		return wherePart;
	}

}
