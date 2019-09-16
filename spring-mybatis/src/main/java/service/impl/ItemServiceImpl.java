package service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import mapper.ItemMapper;
import pojo.Item;
import service.ItemService;


@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemMapper itemapper;
	
	public List<Item> queryItemList() {
		List<Item> list = itemapper.selectAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Item selectById(int id) {
		// TODO Auto-generated method stub
		Item item = itemapper.selectById(id);
		return item;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		int i = itemapper.updateItem(item);
		return i;
	}

	
	
}
