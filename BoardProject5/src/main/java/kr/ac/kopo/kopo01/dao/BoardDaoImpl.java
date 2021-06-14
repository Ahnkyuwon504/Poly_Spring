package kr.ac.kopo.kopo01.dao;

import java.util.List;

import kr.ac.kopo.kopo01.domain.Board;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void create(Board board) {
		
	}

	@Override
	public Board selectOne(int id) {
		Board board = new Board();
		board.setId(1);
		board.setTitle("abcddddddddd");
		return board;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return null;
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
