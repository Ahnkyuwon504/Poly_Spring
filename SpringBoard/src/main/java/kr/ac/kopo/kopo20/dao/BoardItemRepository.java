package kr.ac.kopo.kopo20.dao;

import java.util.List;

import kr.ac.kopo.kopo20.domain.BoardItem;

public interface BoardItemRepository {
	void create(BoardItem boarditem);
	BoardItem selectOne(int itemid);
	List<BoardItem> selectAll(int boardid);
	List<BoardItem> selectAll(int boardid, String keyword);
	void update(BoardItem boarditem, String title, String content);
	void delete(BoardItem boarditem);
	List<BoardItem> getAllComments(BoardItem boarditem);
	void createComment(BoardItem boarditem, BoardItem comment);

}
