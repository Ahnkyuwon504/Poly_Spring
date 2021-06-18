package board.service;

import java.util.List;

import board.domain.Board;
import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class BoardServiceImpl implements BoardService {
	
	private static BoardServiceImpl instance = new BoardServiceImpl();
	
	private BoardServiceImpl() {
		
	}
	
	public static BoardServiceImpl getInstance() {
		return instance;
	}
	
	private BoardDao boardDao = BoardDaoImpl.getInstance();
	
	static Connection conn;
	static Statement stmt;
	static ResultSet rset;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
	
	public List<Board> searchOne(String text) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from board where title like '%" + text + "%';");
			ArrayList<Board> listOfBoard = new ArrayList<Board>();
			
			while (rset.next()) {
				Board board = new Board();
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setDate(rset.getString(3));
				board.setContent(rset.getString(4));
				
				listOfBoard.add(board);
			}
			
			rset.close();
			stmt.close();
			conn.close();
			
			return listOfBoard;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		
	}
	
	public int howMany() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select count(*) from board;");
			int howMany = 0;
			
			while (rset.next()) {
				howMany = rset.getInt(1);
			}
			
			rset.close();
			stmt.close();
			conn.close();
			
			return howMany;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
