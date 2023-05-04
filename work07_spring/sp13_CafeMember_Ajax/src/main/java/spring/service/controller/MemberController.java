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

	@RequestMapping("find.do") // Scope�� Request
	public String find(Model model, String id) throws Exception {
		MemberVO rvo = memberService.getMember(id);

		if (rvo != null) {
			model.addAttribute("vo", rvo); // ������ ���ε�
			return "find_ok"; // ��� ������ ��ȯ -> ����Ÿ���� String
		} else {
			return "find_fail";
		}
	}

	@RequestMapping("login.do")
	// HttpSession�� ���ε��ص� �ȴ�. == request.getSession()
	// �� �а� ���� ���� �� Request�� ������ ��
	public String login(HttpServletRequest request, MemberVO pvo) throws Exception {
		MemberVO rvo = memberService.login(pvo);
		// �α��� �� Model�� ���ε� �ϸ� �ȵȴ�. Scope�� Request�̱� �����̴�.
		if (rvo != null) {
			// ���ǿ� ���ε��ؾ� �Ǵ� �˰��� - login, update�� �ݵ��!!!
			request.getSession().setAttribute("vo", rvo);
			return "login_result";
		}
		return "redirect:/index.jsp"; // redirect�ϰڴٴ� �ǹ�
		
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
		
		// �α��� �� ���¿����� '����(update)'�� �����ϴ�.
		if (session.getAttribute("vo") != null) { // �α��ε� ���¶��
			session.setAttribute("vo", pvo); 
			return "update_result";
		}
		return null;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		// �α��� �� ���¿����� '�α׾ƿ�(logout)'�� �����ϴ�.
		if (session.getAttribute("vo") != null) { // �α��ε� ���¶�� �α׾ƿ�
			// ������ KILL
			session.invalidate(); 
			return "logout";
		}
		return null;		
	}
	
	@RequestMapping("idExist.do")
	public String idExist(Model model, String id) throws Exception {
		String rid = memberDAO.idExist(id);
		System.out.println("rid=" + rid);
		boolean idExist = false;
		if (rid != null) idExist = true; // DB�� id�� �����ϸ� idExist�� true / �������������� idExist�� false
		model.addAttribute("idExist", idExist);
		return "JsonView"; // �񵿱� ��� ȭ��		
	}
	
}
