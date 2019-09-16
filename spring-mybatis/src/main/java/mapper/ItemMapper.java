package mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import pojo.Item;


public interface ItemMapper {
   
    
    List<Item> selectAll();

    Item selectById(int id);
    
    int updateItem(Item item);
}