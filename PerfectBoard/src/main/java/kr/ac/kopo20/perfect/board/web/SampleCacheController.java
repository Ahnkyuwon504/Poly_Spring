package kr.ac.kopo20.perfect.board.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo20.perfect.board.service.BoardItemService;

@Controller
public class SampleCacheController {
	
	@Autowired
	private BoardItemService boardItemService;
	
	@RequestMapping(value = "/sample/noCache")
	@ResponseBody
	public String noCache(@RequestParam HashMap<String, String> map) {
		Long id = Long.parseLong(map.get("id"));
		return boardItemService.testNoCache(id);
	}
	
	
	@RequestMapping(value = "/sample/cache")
	@ResponseBody
	public String cache(@RequestParam HashMap<String, String> map) {
		Long id = Long.parseLong(map.get("id"));
		return boardItemService.testCache(id);
	}
	
	

	
	
	

}
