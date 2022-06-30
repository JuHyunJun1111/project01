package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
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
		list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//게시물 작성(페이지 이동)
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getWrite() throws Exception {
	
	}
		
	//게시물 작성(insert) 
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String insert(BoardVO vo) throws Exception {
		service.write(vo);
		
		//리스트로 바로 이동
		return "redirect:/board/list";
	}

}
