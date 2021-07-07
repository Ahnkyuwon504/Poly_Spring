package kr.ac.kopo20.perfect.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	   @RequestMapping(value = "/hello") 
	   public String hellSpringBoot(Model model) {
		   model.addAttribute("name", "완벽한 게시판");
		   return "hello";
	   }
}
