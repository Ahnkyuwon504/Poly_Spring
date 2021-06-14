package kr.ac.kopo.kopo01.dao;

import java.util.List;

import kr.ac.kopo.kopo01.domain.Board;
import kr.ac.kopo.kopo01.domain.BoardItem;

public interface BoardItemDao {
	void create(BoardItem boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll();
	void update(BoardItem boardItem);
	void delete(BoardItem boardItem);
}
