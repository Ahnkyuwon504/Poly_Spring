package kr.ac.kopo.kopo20.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kopo20.domain.Board;
import kr.ac.kopo.kopo20.service.BoardService;

@Controller
public class BoardController {
	
	//private BoardService boardService = new BoardServiceImpl();
	// 이제 이거 안 써
	@Autowired
	private BoardService boardService;

    @RequestMapping(value = "/board") 
    public String hellSpringBoot(Model model) {
    	List<Board> boardList = boardService.selectAll();
    	
    	model.addAttribute("boardList", boardList); 
    	return "board"; 
    }
}
