package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService  {
	
	//게시물 목록
	//public List<BoardVO> boardList() throws Exception;
	
	// 게시물 목록 + 페이징 + 검색
	public List<BoardVO> boardListPage(int displayPost, int postNum, 
				String searchType, String keyword) throws Exception;
	
	//게시물 총 갯수
	public int boardCount(String searchType, String keyword) throws Exception; 
	
	//게시물 작성 
	public void boardInsert(BoardVO vo) throws Exception;
	
	//게시물 조회 
	public BoardVO boardView(int bno) throws Exception;
	
	//게시물 수정	
	public void boardModify(BoardVO vo) throws Exception;
	
	//게시물 삭제	
	public void boardDelete(int bno) throws Exception;

}
