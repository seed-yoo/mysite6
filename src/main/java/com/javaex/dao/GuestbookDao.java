package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<GuestbookVo> guestbookSelect() {
		System.out.println("GuestbookDao.guestbookSelect()");

		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");

		// System.out.println(personList);

		return guestbookList;
	}

	// 1개 가져오기2
	public Map<String, Object> guestbookSelectOne2(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");

		Map<String, Object> pMap = sqlSession.selectOne("guestbook.selectOne2", no);
		// System.out.println(pMap);
		// System.out.println(pMap.get("name"));

		return pMap;
	}

	// 수정
	public int guestbookModify(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.guestbookModify()");

		int count = sqlSession.update("guestbook.guestbookUpdate", guestbookVo);

		return count;

	}

	// 삭제
	public int guestbookDelete(Map<String, String> gMap) {

		int count = sqlSession.delete("guestbook.guestbookDelete", gMap);
		// System.out.println(count);

		return count;
	}

	// 게스트북등록
	public int guestbookInsert(GuestbookVo guestbookVo) {

		int count = sqlSession.insert("guestbook.guestbookInsert", guestbookVo);

		return count;
	}

	// ajax등록
	public int insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertSelectKey()");

		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);

		return count;
	}

	// 데이터 1개 가져오기 no 1개 데이터 가져오기
	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");

		GuestbookVo guestbookVo = sqlSession.selectOne("guestbook.selectOne", no);
		System.out.println(guestbookVo);
		return guestbookVo;
	}

	// ajax삭제
	public int deleteSelectKey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.deleteSelectKey()");

		int count = sqlSession.delete("guestbook.deleteSelectKey", guestbookVo);
		
		return count;
	}

}
