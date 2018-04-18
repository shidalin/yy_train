package nc.util.apiplat.TreeUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * �ӿ�ƽ̨���ṹ���칤���� <br/>
 * shidl@yonyou.com <br/>
 * 2018/04/14<br/>
 * 
 */
public class TreeUtil {

	/**
	 * ���ݸ��ڵ㹹����
	 * 
	 * @param root
	 * @param childList
	 * @return
	 */
	public TreeEntity getTreeList(TreeEntity root, List<TreeEntity> childList) {
		root.setLevel(1);
		findChildren(root, childList);
		return root;
	}

	private List<TreeEntity> findChildren(TreeEntity root,
			List<TreeEntity> allNodes) {
		List<TreeEntity> children = new ArrayList<TreeEntity>();

		for (TreeEntity comparedOne : allNodes) {
			if (comparedOne.getFatherId().equals(root.getId())) {
				root.getChildList().add(comparedOne);
				comparedOne.setLevel(root.getLevel() + 1);
				children.add(comparedOne);
			}
		}
		List<TreeEntity> notChildren = (List<TreeEntity>) CollectionUtils
				.subtract(allNodes, children);

		for (TreeEntity child : children) {
			List<TreeEntity> tmpChildren = findChildren(child, notChildren);
			if (tmpChildren == null || tmpChildren.size() < 1) {
				child.setIsleaf(true);
			} else {
				child.setIsleaf(false);
			}
		}
		return children;
	}

}