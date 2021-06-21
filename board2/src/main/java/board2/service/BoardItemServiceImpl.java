package board2.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import board2.dao.BoardItemDao;
import board2.dao.BoardItemDaoImpl;
import board2.domain.BoardItem;

public class BoardItemServiceImpl implements BoardItemService {
	private static BoardItemServiceImpl instance = new BoardItemServiceImpl();
	private BoardItemServiceImpl() {
	}
	
	public static BoardItemServiceImpl getInstance() {
		return instance;
	}
	
	private BoardItemDao boardItemDao = BoardItemDaoImpl.getInstance();
	
	
	
	
	@Override
	public void create(BoardItem boarditem) {
		// TODO Auto-generated method stub
		boardItemDao.create(boarditem);
		
	}

	@Override
	public BoardItem selectOne(int itemid) {
		// TODO Auto-generated method stub
		return boardItemDao.selectOne(itemid);
	}

	@Override
	public List<BoardItem> selectAll(int boardid) {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll(boardid);
	}

	@Override
	public void update(BoardItem boarditem, String title, String content) {
		// TODO Auto-generated method stub
		boardItemDao.update(boarditem, title, content);
		
	}

	@Override
	public void delete(BoardItem boarditem) {
		// TODO Auto-generated method stub
		boardItemDao.delete(boarditem);
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
		return boardItemDao.getAllComments(boarditem);
	}

	@Override
	public void createComment(BoardItem boarditem, BoardItem comment) {
		// TODO Auto-generated method stub
		boardItemDao.createComment(boarditem, comment);
		
	}

	@Override
	public List<BoardItem> selectAll(int boardid, String keyword) {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll(boardid, keyword);
	}
}
