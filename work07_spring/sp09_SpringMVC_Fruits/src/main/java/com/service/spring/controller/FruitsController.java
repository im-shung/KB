package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

@Controller
public class FruitsController {

	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("/list.do")
	public ModelAndView list() throws Exception {
		List<Item> list = itemCatalog.getItemList();
		
		/*
		 * param1 : jsp 파일 이름
		 * param2 : key
		 * param3 : value
		 */
		return new ModelAndView("itemList", "list", list); // 
	}
	
	@RequestMapping("/detail.do")
	public ModelAndView detail(int itemnumber) throws Exception {// parameter이름 자동바인딩
		Item item = itemCatalog.getItem(itemnumber);
		return new ModelAndView("detail", "item", item);
		
	}
}
