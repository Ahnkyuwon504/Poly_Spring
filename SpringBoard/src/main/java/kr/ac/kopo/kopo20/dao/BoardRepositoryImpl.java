package kr.ac.kopo.kopo20.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo20.domain.*;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
	static Connection conn;
	static Statement stmt;
	static ResultSet rset;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.97:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.97:33060/kopoctc", "root", "kopoctc");
			stmt = conn.createStatement();
			ArrayList<Board> listOfBoard = new ArrayList<Board>();
			rset = stmt.executeQuery("select * from board;");
			
			while (rset.next()) {
				Board board = new Board(rset.getInt(1), rset.getString(2));
				
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

}
