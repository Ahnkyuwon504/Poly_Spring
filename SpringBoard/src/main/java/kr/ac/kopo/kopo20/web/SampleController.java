package kr.ac.kopo.kopo20.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo20.dao.SampleRepository;
import kr.ac.kopo.kopo20.dao.SampleSpecs;
import kr.ac.kopo.kopo20.domain.Sample;

@Controller
public class SampleController {
	
   @Autowired
   private SampleRepository sampleRepository;
   
	/*
	 * @Autowired private SampleSpecs sampleSpecs;
	 * 필요 없어... 왜냐하면 SampleSpecs클래스의 static method를 사용할 거라서...
	 * 메인은 SampleSpecs가 아니라, Sample repository이다...
	 */
  
   
   @RequestMapping(value = "/sample/pageable") 
   @ResponseBody
   public List<Sample> pageable(Model model) {
	   PageRequest pageable = PageRequest.of(0, 10);
	   Page<Sample> page = sampleRepository.findAll(pageable);
	   
	   return page.getContent();
   }
   
	
   @RequestMapping(value = "/sample/search")
   @ResponseBody 
   public Page<Sample> search(Model model) {
	   Map<String, Object> filter = new HashMap<String, Object>();
	   filter.put("title", "첫 번째 샘플");
	
	   PageRequest pageable = PageRequest.of(0, 10);
	   Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
	   
	   return page;
   }
}
