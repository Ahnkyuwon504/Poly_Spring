package kr.ac.kopo.kopo20.dao;

import java.util.List;

import kr.ac.kopo.kopo20.domain.Board;

public interface BoardRepository {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void delete(Board board);

}
