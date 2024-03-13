package com.javaex.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody	// return의 데이터를 json방식으로 변경해서 응답 문서(response)의 바디(body)에 붙여서 보내줌
	@RequestMapping(value="/api/guestbooks", method = RequestMethod.GET)
	public List<GuestbookVo> list() {
		System.out.println("ApiGuestbookController.list()");
		
		List<GuestbookVo> guestbookList = guestbookService.exeList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	
	
}
