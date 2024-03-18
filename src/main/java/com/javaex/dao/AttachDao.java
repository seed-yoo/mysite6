package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AttachVo;

@Repository
public class AttachDao {

	@Autowired
	private SqlSession sqlSession;

	// 파일등록
	public int attachInsert(AttachVo attachVo) {
		System.out.println("AttachDao.attachInsert()");
		
		//System.out.println(attachVo);
		int count = sqlSession.insert("attachInsert", attachVo);

		return count;
	}
	
	

}
