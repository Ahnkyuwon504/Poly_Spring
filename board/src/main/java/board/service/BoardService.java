package board.service;

import java.util.List;

import board.domain.Board;

public interface BoardService {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void update(Board board, String title, String content);
	void delete(Board board);
	String getDate();
	List<Board> searchOne(String text);
	int howMany();

}
