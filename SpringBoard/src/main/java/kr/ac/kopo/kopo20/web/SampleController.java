package kr.ac.kopo.kopo20.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo20.dao.SampleRepository;
import kr.ac.kopo.kopo20.domain.Sample;

@Controller
public class SampleController {
	
	   @Autowired
	   private SampleRepository sampleRepository;
	
	   @RequestMapping(value = "/sample/list") 
	   @ResponseBody
	   public List<Sample> hellSpringBoot(Model model) {
		   return sampleRepository.findAll();
	   }
}
