package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.PageResult;

public interface ItemService {
	
   public TbItem findItemById(Long itemId);
   
   /**
    * 根据查询参数 进行分页查询
    */
   public PageResult findItemListByPage(Integer page,Integer rows);
   
   /**
    * 保存商品数据
    */
   public E3mallResult saveItem(TbItem item,TbItemDesc itemDesc);
}
