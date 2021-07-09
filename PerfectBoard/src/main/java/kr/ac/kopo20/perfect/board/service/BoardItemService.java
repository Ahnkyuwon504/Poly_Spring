package kr.ac.kopo20.perfect.board.service;

import org.springframework.stereotype.Service;

@Service
public interface BoardItemService {
	String getDate();
	void test();
	void testAop();
	String testNoCache(Long id);
	String testCache(Long id);
	void testCacheClear(Long id);

}
