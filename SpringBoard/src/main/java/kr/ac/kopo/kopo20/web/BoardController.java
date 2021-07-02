package kr.ac.kopo.kopo20.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kopo20.service.BoardItemService;
import kr.ac.kopo.kopo20.service.BoardService;

@Controller
public class BoardController {
	
	//private BoardService boardService = new BoardServiceImpl();
	// 이제 이거 안 써
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardItemService boardItemService;
	
	@RequestMapping(value = "/hello")
	public String hellSpringBoot(Model model) {
		model.addAttribute("name", "홍길동");
		return "hello";
	}


}
