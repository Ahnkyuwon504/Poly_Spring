package kr.ac.kopo20.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	   @RequestMapping(value = "/hello") 
	   public String hellSpringBoot(Model model) {
		   model.addAttribute("name", "홍길동");
		   return "hello";
	   }
}
