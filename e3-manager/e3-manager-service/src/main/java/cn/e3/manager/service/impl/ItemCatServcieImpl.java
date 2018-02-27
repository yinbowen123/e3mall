package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeNode;
@Service
public class ItemCatServcieImpl implements ItemCatService {
   @Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<TreeNode> findItemCatTreeNodeList(Long parentId) {
		// TODO Auto-generated method stub
		
		List<TreeNode> nodeList =new ArrayList<>();
		
		
		TbItemCatExample example =new TbItemCatExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		for (TbItemCat tbItemCat : list) {
			
			TreeNode treeNode =new TreeNode();
			
			treeNode.setId(tbItemCat.getId());
			
			treeNode.setText(tbItemCat.getName());
			
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");;
			
			nodeList.add(treeNode);
		}
		
		
		return nodeList;
	}

}
