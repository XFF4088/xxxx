package service;

import java.util.List;

import pojo.Item;


public interface ItemService {
	List<Item> queryItemList();
	
	Item selectById(int id);
	
	int updateItem(Item item);
}
