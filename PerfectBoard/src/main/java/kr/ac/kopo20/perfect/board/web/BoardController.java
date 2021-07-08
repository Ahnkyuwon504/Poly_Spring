package kr.ac.kopo20.perfect.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo20.perfect.board.domain.Board;
import kr.ac.kopo20.perfect.board.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping(value = "/board")
	public String getBoard(Model model) {
		List<Board> boardList = boardRepository.findAll();
		model.addAttribute("boardList", boardList);
		return "board";
	}
}
