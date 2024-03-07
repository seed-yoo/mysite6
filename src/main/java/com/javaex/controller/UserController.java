package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	// 필드
	@Autowired
	private UserService userService;

	// =============== user/form controller 모음
	// ==============================================
	// 로그인폼
	@RequestMapping(value = "/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController.loginform");
		return "/user/loginForm";
	}

	// 회원가입폼
	@RequestMapping(value = "/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinform");
		return "/user/joinForm";
	}

	// 가입완료폼
	@RequestMapping(value = "/joinok", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinOk() {
		System.out.println("UserController.joinok");
		return "/user/joinOk";
	}

	// 수정폼
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm() {
		System.out.println("UserController.modifyform");
		
		return "/user/modifyForm";
	}

	// 수정폼2
	@RequestMapping(value = "/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(HttpSession session, Model model) {
		System.out.println("UserController.modifyform2");

		// 세션에서 주소 가져오고, no 가져오기
		UserVo loginUserInfo = (UserVo) session.getAttribute("authUser");
		int userNo = loginUserInfo.getNo();

		// no가지고 서비스로 넘기기
		UserVo userNoVo = userService.exeMform(userNo);

		// 받은 주소값을 Attribute에 넣기
		model.addAttribute("userVo", userNoVo);
		System.out.println(userNoVo);
		
		return "/user/modifyForm";
	}

	// ==============================================================================================

	// =============== user 기능 모음
	// ==================================================================

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login");

		System.out.println(userVo);

		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);

		session.setAttribute("authUser", authUser);

		// 리스트로 리다이렉트
		// return "redirect:/main";
		return "redirect:/main";

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UserController.logout");

		session.invalidate();

		return "redirect:/main";

	}

	// 회원가입
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join");

		System.out.println(userVo.toString());

		// 서비스를 메모리에 올리고
		// 서비스의 메소드 사용
		userService.exeJoin(userVo);

		// 리스트로 리다이렉트
		return "redirect:/user/joinok";

	}

	// 회원가입2
	@RequestMapping(value = "/join2", method = { RequestMethod.GET, RequestMethod.POST })
	public String join2(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw,
			@RequestParam(value = "name") String name, @RequestParam(value = "gender") String gender) {
		System.out.println("UserController.join2");

		// System.out.println(name);
		// System.out.println(hp);
		// System.out.println(company);

		// vo 묶는다
		// PersonVo personVo = new PersonVo(name, hp, company);

		userService.exeJoin2(id, pw, name, gender);

		// 리스트로 리다이렉트
		return "redirect:/user/joinok";
	}

	// 유저정보수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo) {

		System.out.println("UserController.modify()");

		// System.out.println(personVo);

		userService.exeModify(userVo);

		// 리스트로 리다이렉트
		return "redirect:/main";
	}

	// 회원정보 수정2
	@RequestMapping(value = "/modify2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify2(@RequestParam(value = "pw") String pw, @RequestParam(value = "name") String name,
			@RequestParam(value = "gender") String gender, HttpSession session) {// password=ljh&name=ljh&gender=female&no=3(세션no)
		System.out.println("UserController.modify");
		// 하나씩 받는거 말고 userVo로 받고, 나중에 session으로 받은건 setter로 추가해주면 된다!예시

		// session에서 no꺼내서 userVo와 함께 묶기
		UserVo uVo = (UserVo) session.getAttribute("authUser");
		int num = uVo.getNo();

		UserVo userVo = new UserVo(num, pw, name, gender);

		System.out.println(userVo);

		// 서비스로 묶은거 넘기기
		userService.exeModify(userVo);
		
		
		
		session.setAttribute("authUser", userVo);
		

		// 메인화면으로 리다이렉트
		return "redirect:/main";
	}

	// 회원정보삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("UserController.delete()");

		// System.out.println(personId);

		userService.exeDelete(no);

		// 리스트로 리다이렉트
		return "redirect:/main";

	}

}
