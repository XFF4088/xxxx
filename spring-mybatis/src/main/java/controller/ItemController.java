package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pojo.Item;
import pojo.QueryVo;
import service.ItemService;




@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	/**
	 * 显示商品列表
	 * 
	 * @return
	 */
	@RequestMapping("/itemList")
	public ModelAndView queryItemList() {
		// 获取商品数据
		List<Item> list = this.itemService.queryItemList();

		ModelAndView modelAndView = new ModelAndView();
		// 把商品数据放到模型中
		modelAndView.addObject("itemList", list);
		// 设置逻辑视图
		modelAndView.setViewName("itemList");

		return modelAndView;
	}
	
	@RequestMapping("/itemEdit.action")
	public ModelAndView queryItemById(int id) {
		// 获取商品数据
		Item item = this.itemService.selectById(id);
		ModelAndView modelAndView = new ModelAndView();
		// 把商品数据放到模型中
		modelAndView.addObject("item", item);
		// 设置逻辑视图
		modelAndView.setViewName("editItem");

		return modelAndView;
	}
	
	@RequestMapping("/updateitem.action")
	public ModelAndView updateItem(HttpServletRequest req,Item item,MultipartFile pictureFile) throws IllegalStateException, IOException {
		
		String picName = UUID.randomUUID().toString();

		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 开始上传 准备移动
		pictureFile.transferTo(new File("C:\\Users\\Lenovo\\Desktop\\图片\\" + picName + extName));

		// 设置图片名到商品中
		item.setPic(picName + extName);

		int i = itemService.updateItem(item);
		String inf = "修改失败";
		if(i>0) {
			inf = "修改成功";
		}
		req.setAttribute("info", inf);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item",item);
		modelAndView.setViewName("editItem");

		return modelAndView;
	}
}

