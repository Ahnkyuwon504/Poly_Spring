package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.domain.Board;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDaoImpl instance = new BoardDaoImpl();
	
	private BoardDaoImpl() {
	}
	
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
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
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "insert into board (title, date, content) values ('" + 
					board.getTitle() + "', '" + 
					board.getDate() + "', '" + 
					board.getContent()  + "');";
			stmt.execute(QueryTxt);

			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Board selectOne(int id) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from board where id=" + id + ";");
			
			Board board = new Board();
			
			while (rset.next()) {
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setDate(rset.getString(3));
				board.setContent(rset.getString(4));
			}
			
			rset.close();
			stmt.close();
			conn.close();
			
			return board;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Board> selectAll() {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			ArrayList<Board> listOfBoard = new ArrayList<Board>();
			rset = stmt.executeQuery("select * from board;");
			//conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			
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

	@Override
	public void update(Board board) {
		
	}
	
	public void update(Board board, String title, String content) {
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			int id = board.getId();
			
			String QueryTxt = "update board set title='" + title + "', content='" + content + "' where id=" + id + ";";
					
			stmt.execute(QueryTxt);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.20:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

			String QueryTxt = "delete from board where id=" + board.getId() + ";";
			stmt.execute(QueryTxt);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
