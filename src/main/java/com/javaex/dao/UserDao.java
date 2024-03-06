package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public UserVo userSelectByIdPw(UserVo userVo) {

		System.out.println("UserDao.userSelectByIdPw");

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);

		System.out.println(authUser);

		return authUser;
	}

	// 회원정보등록등록
	public int userInsert(UserVo userVo) {

		int count = sqlSession.insert("user.userInsert", userVo);

		return count;
	}

	// 회원정보등록2
	public int userInsert2(Map<String, String> pMap) {
		System.out.println("userDao.userInsert2()");
		System.out.println(pMap);

		int count = sqlSession.insert("user.userInsert2", pMap);

		return count;
	}

	// 회원정보 수정폼
	public UserVo userSelectOne(int no) {
		System.out.println("UserDao.userSelectOne");

		UserVo userVo = sqlSession.selectOne("user.selectOne", no);
		System.out.println(userVo);
		return userVo;
	}

	// 회원정보수정
	public int userModify(UserVo userVo) {
		System.out.println("userDao.userModify()");

		int count = sqlSession.update("user.userUpdate", userVo);

		return count;

	}

	// 삭제
	public int userDelete(int no) {

		int count = sqlSession.delete("user.delete", no);
		// System.out.println(count);

		return count;
	}

}
