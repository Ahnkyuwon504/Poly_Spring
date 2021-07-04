package kr.ac.kopo.kopo20.service;

import java.util.List;

import kr.ac.kopo.kopo20.domain.*;

public interface BoardItemService {
	void create(BoardItem boarditem);
	BoardItem selectOne(int itemid);
	List<BoardItem> selectAll(int boardid);
	List<BoardItem> selectAll(int boardid, String keyword);
	void update(BoardItem boarditem, String title, String content);
	void delete(BoardItem boarditem);
	String getDate();
	List<BoardItem> getAllComments(BoardItem boarditem);
	void createComment(BoardItem boarditem, BoardItem comment);
	String getKeyWord(String search);
	int[] getFromAndTo(String strfrom, String strto, int boardItemHowMany, int onePage);

}
