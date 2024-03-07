package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReplyVo;

@Repository
public class ReplyDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<ReplyVo> replySelect() {
		System.out.println("ReplyDao.replySelect()");

		List<ReplyVo> replyList = sqlSession.selectList("reply.replySelectList");
		// System.out.println(personList);

		return replyList;
	}

	// 게시판등록
	public int replyInsert(ReplyVo replyVo) {

		int count = sqlSession.insert("replyInsert", replyVo);

		return count;
	}

	// 게시판등록2
	public int replyInsert2(Map<String, String> rbMap) {
		System.out.println("boardDao.boardInsert2()");
		System.out.println(rbMap);

		int count = sqlSession.insert("reply.replyInsert2", rbMap);

		return count;
	}

	// 1개 가져오기
	public ReplyVo replySelectOne(int no) {
		System.out.println("ReplyDao.replySelectOne()");

		ReplyVo replyVo = sqlSession.selectOne("reply.replyselectOne", no);
		//System.out.println(replyVo);
		return replyVo;
	}

	// 수정
	public int replyModify(ReplyVo replyVo) {
		System.out.println("ReplyDao.replyModify()");

		int count = sqlSession.update("reply.replyUpdate", replyVo);

		return count;

	}

	// 삭제
	public int replyDelete(int no) {

		int count = sqlSession.delete("reply.replyDelete", no);
		// System.out.println(count);

		return count;
	}

}
