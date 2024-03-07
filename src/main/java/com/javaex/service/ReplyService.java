package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ReplyDao;
import com.javaex.vo.ReplyVo;

@Service
public class ReplyService {

	// 필드
	@Autowired
	private ReplyDao replyDao;

	// 댓글등록
	public int exeWrite(ReplyVo replyVo) {
		System.out.println("ReplyService.exeWrite()");

		int count = replyDao.replyInsert(replyVo);

		return count;
	}

	// 댓글등록2
	public int exeWrite2(String title, String content) {
		System.out.println("ReplyService.exeWrite2()");

		// map 사용
		Map<String, String> replyMap = new HashMap<String, String>();
		replyMap.put("title", title);
		replyMap.put("content", content);

		int count = replyDao.replyInsert2(replyMap);

		return count;
	}

	// 리스트
	public List<ReplyVo> exeList() {
		System.out.println("ReplyService.exeList()");

		List<ReplyVo> replyList = replyDao.replySelect();

		return replyList;
	}

	// 수정폼
	public ReplyVo exeModifyForm(int no) {
		System.out.println("ReplyService.exeModifyForm()");

		// 비지니스로직X

		ReplyVo replyVo = replyDao.replySelectOne(no);

		return replyVo;

	}

	// 수정
	public int exeModify(ReplyVo replyVo) {
		System.out.println("ReplyService.exeModify()");

		int count = replyDao.replyModify(replyVo);
		return count;
	}

	// 삭제
	public int exeDelete(int no) {
		System.out.println("ReplyService.exeDelete()");

		int count = replyDao.replyDelete(no);

		return count;
	}

}
