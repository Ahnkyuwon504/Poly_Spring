package board.service;

import java.util.List;

import board.domain.Board;
import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = BoardDaoImpl.getInstance();

	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		boardDao.create(board);
		
	}

	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		boardDao.update(board);
		
	}
	
	public void update(Board board, String title, String content) {
		// TODO Auto-generated method stub
		boardDao.update(board);
		boardDao.update(board, title, content);
	}


	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		boardDao.delete(board);
		
	}
	
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(new Date());
		SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
		
		return sf.format(cal.getTime());
	}
}
