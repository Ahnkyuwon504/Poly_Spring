package kr.ac.kopo.kopo20.web;

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
