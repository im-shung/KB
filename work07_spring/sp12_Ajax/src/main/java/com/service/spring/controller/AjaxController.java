package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {

	@RequestMapping("/") // http:127.0.0.1:8899/sp12_Ajax
	public String index() {
		System.out.println(" context path..request..");
		return "redirect:index.jsp"; // redirect는 Presentation Layer 빈 설정문서의 영향을 받지 않기 때문에 확장자도 써줘야한다.
	}
	
	@RequestMapping("sysnchro")
	public String sysnchro(Model model) {
		System.out.println(" sysnchro..request..");
		model.addAttribute("info", "와~~동기 통신이다...");
		return "sysnchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("asynch.. request...");
		model.addAttribute("person", new Person("jams", "texas"));
		return "JsonView";
	}
	
}
