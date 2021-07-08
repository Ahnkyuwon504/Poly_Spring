package kr.ac.kopo20.perfect.board.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

}
