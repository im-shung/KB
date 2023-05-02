package spring.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;
import spring.service.model.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private MemberService memberService;

	@RequestMapping("find.do") // Scope가 Request
	public String find(Model model, String id) throws Exception {
		MemberVO rvo = memberService.getMember(id);

		if (rvo != null) {
			model.addAttribute("vo", rvo); // 데이터 바인딩
			return "find_ok"; // 결과 페이지 반환 -> 리턴타입이 String
		} else {
			return "find_fail";
		}
	}

	@RequestMapping("login.do")
	// HttpSession에 바인딩해도 된다. == request.getSession()
	// 더 넓게 쓰기 위해 에 Request를 가져온 것
	public String login(HttpServletRequest request, MemberVO pvo) throws Exception {
		MemberVO rvo = memberService.login(pvo);
		// 로그인 시 Model에 바인딩 하면 안된다. Scope가 Request이기 때문이다.
		if (rvo != null) {
			// 세션에 바인딩해야 되는 알고리즘 - login, update에 반드시!!!
			request.getSession().setAttribute("vo", rvo);
			return "login_result";
		}
		return "redirect:/index.jsp"; // redirect하겠다는 의미
		
	}

	@RequestMapping("register.do")
	public String register(MemberVO pvo) throws Exception {
		memberDAO.registerMember(pvo);
		return "redirect:/showAll.do";
	}

	@RequestMapping("showAll.do")
	public String showAll(Model model) throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		model.addAttribute("list", list);
		return "allView";
	}
	
	@RequestMapping("update.do")
	public String update(HttpSession session, MemberVO pvo) throws Exception {
		memberDAO.updateMember(pvo);
		
		// 로그인 된 상태에서만 '수정(update)'이 가능하다.
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면
			session.setAttribute("vo", pvo); 
			return "update_result";
		}
		return null;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		// 로그인 된 상태에서만 '로그아웃(logout)'이 가능하다.
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면 로그아웃
			// 세션을 KILL
			session.invalidate(); 
			return "logout";
		}
		return null;		
	}
	
}
