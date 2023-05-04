package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@GetMapping("/")
	public String index() { // 메인 화면
		return "redirect:index.jsp";
	}

	@GetMapping("regPhone") // 핸드폰 등록 화면을 요청
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}

	@PostMapping("savePhone") // 핸드폰 등록 화면에서 '저장'버튼 클릭
	public String doSavePhone(Phone phone, Model model) {
		try {
			// 성공페이지
			phoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
		} catch (Exception e) {
			// 실패페이지
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}

	@GetMapping("searchPhone")
	public String doList(Model model) {
		try {
			List<Phone> list = phoneService.select();
			model.addAttribute("phones", list);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 리스트");
			return "PhoneList";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message", "문제 내용 - 폰 목록 조회 중 에러 발생");
			return "Error";
		}
	}

	@GetMapping("detail")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("phone", selected);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회");
			return "PhoneView";
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message", "핸드폰 관리 - 핸드폰 상세 조회 증 에러 발생");
			return "Error";
		}
	}

	
	// 비동기
	@PostMapping("deleteAjax")
	@ResponseBody // ResponseBody 어노테이션 :: JsonView가 필요없다(빈 설정문서x) + Ajax + 데이터 반환
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<>();
		try {
			
			// 삭제하고자 하는 num을 다 받아온다.
			for (String n : num) {
				temp.add(n);
			}
			
			phoneService.delete(temp);
			
			return ""; // 비동기는 결과 페이지가 없어
		} catch (Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message", "핸드폰 관리 - 핸드폰 목록 삭제 증 에러 발생");
			return "Error";
		}
	}
	
	////////// 로그인 기능 :: UserLoginController /////////////
	@GetMapping("login") // 로그인 페이지로 이동.. get
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = phoneService.select(user);
			if (selected != null) { // 로그인 성공
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone";
			} else { // 로그인 실패
				return "Login";
			}
		} catch (Exception e) {
			model.addAttribute("title", "로그인 에러");
			model.addAttribute("message", "문제 내용 - 로그인 증 에러 발생");
			return "Error";
		}
	}
}
