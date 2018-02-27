package cn.e3.manager.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;
import cn.e3.utils.PageResult;
@Service
public class ItemServcieImpl implements ItemService {
	@Autowired
    private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	
	@Override
	public TbItem findItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		return item;
	}

	@Override
	public PageResult findItemListByPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		TbItemExample example = new TbItemExample(); 
		
		PageHelper.startPage(page, rows);
		
		List<TbItem> list=itemMapper.selectByExample(example);
		
		PageInfo<TbItem> pageInfo =new PageInfo<>(list);
		
		PageResult result =new PageResult();
		
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		
		return result;
	}

	@Override
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		// TODO Auto-generated method stub
		//保存商品对象
		//生成商品id id不能重复  毫秒+随机数
	     long itemId = IDUtils.genItemId();
	     item.setId(itemId);
	     item.setStatus((byte)1);
	     Date date = new Date();
	     item.setCreated(date);
	     item.setUpdated(date);
		itemMapper.insertSelective(item);
		itemDesc.setItemId(itemId);
		itemDesc.setUpdated(date);
		itemDesc.setCreated(date);
		itemDescMapper.insertSelective(itemDesc);
		return E3mallResult.ok();
	}

}
