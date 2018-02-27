package cn.e3.manager.service;

import java.util.List;

import cn.e3.utils.TreeNode;

public interface ItemCatService {

	/**
	 * 根据父id 查询子节点
	 */
	public List<TreeNode> findItemCatTreeNodeList(Long parentId);
}
