package kr.ac.kopo20.perfect.board.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Override
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
		
		return sf.format(cal.getTime());
	}

	@Override
	public void test() {
		System.out.println("BoardItemServiceImpl method");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testAop() {
		System.out.println("BoardItemServiceImpl testAop method");		
	}

	@Override
	public String testNoCache(Long id) {
		// TODO Auto-generated method stub
		String msg = "No Cache";
		System.out.println(msg);
		sleep(3);
		return msg;
	}

	@Override
	@Cacheable(value="sample", key="#id")
	public String testCache(Long id) {
		String msg = "Hello, Cache";
		System.out.println(msg);
		sleep(3);
		return msg;
	}

	@Override
	@CacheEvict(value="sample", key="#id")
	public void testCacheClear(Long id) {
		System.out.println("cache clear => " + id);
		// TODO Auto-generated method stub
		
	}
	
	private void sleep(int second) {
		try {
			Thread.sleep(second * 1000L);
		} catch( InterruptedException ie) {
			throw new IllegalStateException();
		}
	}
	



}
