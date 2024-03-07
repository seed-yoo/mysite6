package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ReplyService;
import com.javaex.vo.ReplyVo;

@Controller
@RequestMapping(value = "/reply")
public class ReplyController {

	// 필드
	@Autowired
	private ReplyService replyService;

	// =============== board/form controller 모음
	// ==============================================
	// 댓글리스트폼
	@RequestMapping(value = "/replyaddlistform", method = { RequestMethod.GET, RequestMethod.POST })
	public String replyaddListForm(Model model) {
		System.out.println("ReplyController.replyaddlistform");

		// 자동연결
		List<ReplyVo> replyList = replyService.exeList();

		model.addAttribute("rList", replyList);

		return "/board/replyaddList";
	}
	
	// 보드리스트폼2
	// @RequestMapping(value = "/listform", method = { RequestMethod.GET, RequestMethod.POST })
	// public String listForm(Criteria cri, Model model) {
		// System.out.println("BoardController.listform");
		
		// 자동연결
		// List<BoardVo> boardList = boardService.exeList();
		
		// model.addAttribute("bList", boardList);
		
		// return "/board/list";
	// }
	/*
	// 보드리스트폼
	@RequestMapping(value = "/listform", method = { RequestMethod.GET, RequestMethod.POST })
	public String replyaddList(Model model) {
		System.out.println("BoardController.listform");

		// 자동연결
		List<BoardVo> boardList = boardService.exeList();

		model.addAttribute("bList", boardList);

		return "/board/list";
	}
*/
	// 보드수정폼
	@RequestMapping(value = "/replymodifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String replymodifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("ReplyController.replymodifyForm");

		ReplyVo replyVo = replyService.exeModifyForm(no);
		
		model.addAttribute("rVo", replyVo);

		return "/board/replymodifyForm";
	}
/*
	// 수정폼2
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@RequestParam(value = "no") int no, Model model) {
		System.out.println("phonebookController.modifyform2()");
		System.out.println(no);

		Map<String, Object> pMap = boardService.exeModifyForm2(no);
		model.addAttribute("pMap", pMap);

		return "/board/modifyForm2";

	}
*/
	// 보드읽기폼
	@RequestMapping(value = "/replyreadform", method = { RequestMethod.GET, RequestMethod.POST })
	public String replyreadForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("ReplyController.replyreadform");

		ReplyVo replyVo = replyService.exeModifyForm(no);
		model.addAttribute("rVo", replyVo);

		return "/board/replyread";
	}

	// ==============================================================================================

	// =============== board 기능 모음
	// =================================================================

	// 게시판등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute ReplyVo replyVo) {
		System.out.println("ReplyController.write");

		System.out.println(replyVo.toString());

		// 서비스를 메모리에 올리고
		// 서비스의 메소드 사용
		replyService.exeWrite(replyVo);

		// 리스트로 리다이렉트
		return "redirect:/reply/replyaddlistform";

	}

	// 게시판등록2
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
		System.out.println("ReplyController.write2");

		// System.out.println(name);
		// System.out.println(hp);
		// System.out.println(company);

		// vo 묶는다
		// PersonVo personVo = new PersonVo(name, hp, company);

		replyService.exeWrite2(title, content);

		// 리스트로 리다이렉트
		return "redirect:/reply/replyaddlistform";
	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute ReplyVo replyVo) {

		System.out.println("ReplyController.modify()");

		System.out.println(replyVo);

		replyService.exeModify(replyVo);

		// 리스트로 리다이렉트
		return "redirect:/reply/replyaddlistform";
	}



	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("ReplyController.delete()");

		// System.out.println(personId);

		replyService.exeDelete(no);

		// 리스트로 리다이렉트
		return "redirect:/reply/replyaddlistform";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
