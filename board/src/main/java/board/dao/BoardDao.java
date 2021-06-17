package board.dao;

import java.util.List;
import board.domain.Board;


public interface BoardDao {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void update(Board board, String title, String content);
	void delete(Board board);
}
