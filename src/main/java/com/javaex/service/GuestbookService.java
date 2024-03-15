package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	// 필드
	@Autowired
	private GuestbookDao guestbookDao;

	// 리스트
	public List<GuestbookVo> exeList() {
		System.out.println("GuestbookService.exeList()");

		List<GuestbookVo> guestbookList = guestbookDao.guestbookSelect();

		return guestbookList;
	}

	// 수정폼
	public GuestbookVo exeDeleteForm(int no) {
		System.out.println("GuestbookService.exeDeleteForm()");

		// 비지니스로직X

		GuestbookVo guestbookVo = guestbookDao.guestbookSelectOne(no);

		return guestbookVo;

	}

	// 수정폼2
	public Map<String, Object> exeModifyForm2(int bno) {
		System.out.println("GuestbookService.exeModifyForm2()");

		Map<String, Object> pMap = guestbookDao.guestbookSelectOne2(bno);

		return pMap;

	}

	// 삭제
	public int exeDelete(int no, String password) {
		System.out.println("GuestbookService.exeDelete()");

		// map 사용
		Map<String, String> gMap = new HashMap<String, String>();
		gMap.put("no", String.valueOf(no));
		gMap.put("password", password);

		int count = guestbookDao.guestbookDelete(gMap);

		return count;
	}

	// 게스트북 등록
	public int exeWrite(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeWrite()");

		int count = guestbookDao.guestbookInsert(guestbookVo);

		return count;
	}

	// ajax 등록 저장
	public GuestbookVo exeAddandGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeAddandGuest()");

		// 저장
		System.out.println("전" + guestbookVo);
		guestbookDao.insertSelectKey(guestbookVo);
		System.out.println("후" + guestbookVo);

		// 1명데이터 가져오기
		GuestbookVo gVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());

		return gVo;
	}

	// ajax 삭제
	public int exeDeleteGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeDeleteGuest()");

		// 저장
		System.out.println("전" + guestbookVo);
		int count = guestbookDao.deleteSelectKey(guestbookVo);
		System.out.println("후" + guestbookVo);

		// 1명데이터 가져오기
		//GuestbookVo gVo = guestbookDao.guestbookSelectOne(guestbookVo.getNo());

		return count;
	}

}
