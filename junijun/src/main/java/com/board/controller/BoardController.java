package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	//의존성 주입
	@Inject
	BoardService service;
	
	//게시판 리스트 불러오기
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<BoardVO> list = null;
		list = service.boardList();
		
		model.addAttribute("list", list);
	}
	
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.boardCount());  

		List list = null; 
		
		list = service.boardListPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list); 
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
	}
	
	
	//게시물 작성(페이지 이동)
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getWrite() throws Exception {
	
	}
		
	//게시물 작성(insert) 
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String boardInsert(BoardVO vo) throws Exception {
		service.boardInsert(vo);
		
		//리스트로 바로 이동
		return "redirect:/board/list";
	}
	
	//게시물 조회
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = service.boardView(bno);
		
		model.addAttribute("view", vo);
	}
	
	//게시물 수정(페이지 이동)
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = service.boardView(bno);
		
		model.addAttribute("view", vo);
		
	}
	
	//게시물 수정(update) 
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String boardModify(BoardVO vo) throws Exception {
		service.boardModify(vo);
		
		//리스트로 바로 이동
		return "redirect:/board/list";
		//return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	//게시물 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String boardDelete(@RequestParam("bno") int bno) throws Exception {
		service.boardDelete(bno);
		
		//리스트로 바로 이동
		return "redirect:/board/list";
		
	}

	


}
