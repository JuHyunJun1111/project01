package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	//게시물 목록
	@Override
	public List<BoardVO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.boardList();
	}
	
	//게시물 목록 + 페이징
	@Override
	public List<BoardVO> boardListPage(int displayPost, int postNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.boardListPage(displayPost, postNum);
	}
	
	//게시물 총 갯수
	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.boardCount();
	}
	
	//게시판 작성
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.boardInsert(vo);
	}
	
	//게시판 조회
	@Override
	public BoardVO boardView(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.boardView(bno);
	}
	
	//게시판 수정
	@Override
	public void boardModify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.boardModify(vo);
	}
	
	//게시물 삭제
	@Override
	public void boardDelete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.boardDelete(bno);
	}

	
	
	

}
