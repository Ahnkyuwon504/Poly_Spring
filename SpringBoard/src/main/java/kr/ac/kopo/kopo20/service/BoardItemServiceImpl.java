package kr.ac.kopo.kopo20.service;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo20.domain.*;
import kr.ac.kopo.kopo20.dao.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService{
	
	/*
	 * @Autowired private BoardRepository boardRepository;
	 */
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Override
	public void create(BoardItem boarditem) {
		// TODO Auto-generated method stub
		boardItemRepository.create(boarditem);
		
	}

	@Override
	public BoardItem selectOne(int itemid) {
		// TODO Auto-generated method stub
		return boardItemRepository.selectOne(itemid);
	}

	@Override
	public List<BoardItem> selectAll(int boardid) {
		// TODO Auto-generated method stub
		return boardItemRepository.selectAll(boardid);
	}

	@Override
	public void update(BoardItem boarditem, String title, String content) {
		// TODO Auto-generated method stub
		boardItemRepository.update(boarditem, title, content);
		
	}

	@Override
	public void delete(BoardItem boarditem) {
		// TODO Auto-generated method stub
		boardItemRepository.delete(boarditem);
	}

	@Override
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(new Date());
		SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
		
		return sf.format(cal.getTime());
	}

	@Override
	public List<BoardItem> getAllComments(BoardItem boarditem) {
		// TODO Auto-generated method stub
		return boardItemRepository.getAllComments(boarditem);
	}

	@Override
	public void createComment(BoardItem boarditem, BoardItem comment) {
		// TODO Auto-generated method stub
		boardItemRepository.createComment(boarditem, comment);
		
	}

	@Override
	public List<BoardItem> selectAll(int boardid, String keyword) {
		// TODO Auto-generated method stub
		return boardItemRepository.selectAll(boardid, keyword);
	}

	@Override
	public String getKeyWord(String search) {
		// TODO Auto-generated method stub
		if (search == null) {
			return "";
		}
		return search;
	}

	@Override
	public int[] getFromAndTo(String strfrom, String strto, int boardItemHowMany, int onePage1) {
		// TODO Auto-generated method stub
		int[] arrayOfFromAndTo = new int[2];
		int onePage = ConstValue.onePage;
		
		int from = 0;
		int to = 0;
		
		if (strfrom == null) {
			from = 1;
			to = onePage;
		} else {
			from = Integer.parseInt(strfrom);
			to = Integer.parseInt(strto);
			
			if (from < 1) {
				from = 1;
				to = onePage;
			}
			
			if (from > boardItemHowMany) {
				from = (boardItemHowMany / onePage) * onePage + 1;
				to = from + onePage - 1;
			}
		}
		
		arrayOfFromAndTo[0] = from;
		arrayOfFromAndTo[1] = to;
		
		return arrayOfFromAndTo;
	}

}
