package nc.ui.train.supclass.ref;

import nc.ui.bd.ref.AbstractRefTreeModel;

/**
 * 供应商分类树形参照
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
	public String[] getFieldCode() {// 参照数据的字段编码
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getFieldName() {// 参照数据的字段名称
		return new String[] { "供应商分类编码", "供应商分类名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {// 需要隐藏的参照数据的字段编码
		// 需要把涉及到但不用的字段放入，不仅是getFieldCode中的字段
		// 例如此处还应该将getFatherField方法中的字段和getChildField方法中的字段放入
		return new String[] { "pk_supclass", "parent_id" };
	}

	@Override
	public String getTableName() {// 参照数据的表名
		return "tr_supclass";
	}

	@Override
	public String getPkFieldCode() {// 参照数据对应表的主键
		return "pk_supclass";
	}

	@Override
	public String getFatherField() {// 树结构的父主键字段
		return "parent_id";
	}

	@Override
	public String getChildField() {// 树结构的子主键字段
		return "pk_supclass";
	}

	@Override
	public String getRefCodeField() {// 参照对应的编码字段
		return "code";
	}

	@Override
	public String getRefNameField() {// 参照对应的名称字段
		return "name";
	}

	@Override
	public String getWherePart() {// 参照数据的过滤条件
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
