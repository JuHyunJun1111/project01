package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace="com.board.mappers.board";
	
	
	//게시물 목록
	@Override
	public List<BoardVO> boardList() throws Exception { 
		return sql.selectList(namespace + ".boardList");
	}
	
	//게시물 목록 + 페이징
	@Override
	public List<BoardVO> boardListPage(int displayPost, int postNum) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".boardListPage", data);
	}

	//게시물 작성
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".boardInsert", vo);
	}

	
	//게시물 조회
	@Override
	public BoardVO boardView(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".boardView", bno);
	}
	
	//게시물 수정
	@Override
	public void boardModify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".boardModify", vo);
	}
	
	//게시물 삭제
	@Override
	public void boardDelete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".boardDelete", bno);
	}
	
	//게시물 총 갯수
	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".boardCount");
	}
	
	
	

}
