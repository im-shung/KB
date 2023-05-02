package com.spring.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.domain.MemberVO;
import com.spring.service.user.MemberService;


@Controller
public class MemberController {	

	@Autowired
	private MemberService memberService;
	@RequestMapping("/find.do")
	public ModelAndView find(String id) throws Exception {
		String path = "find_fail";
        try {
        	MemberVO rvo = memberService.getMember(id);
        	path = "find_ok";
        	return new ModelAndView(path, "vo", rvo);
        } catch(Exception e) {
        	
        }
		
        return new ModelAndView(path);
	}
	
	@RequestMapping("/showAll.do")
	public ModelAndView showAll() throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		
		return new ModelAndView("allView", "list", list);
	}
	
	
	
	
}
