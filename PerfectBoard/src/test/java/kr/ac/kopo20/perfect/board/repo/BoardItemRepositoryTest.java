package kr.ac.kopo20.perfect.board.repo;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo20.perfect.board.domain.Board;
import kr.ac.kopo20.perfect.board.domain.BoardItem;
import kr.ac.kopo20.perfect.board.repository.BoardItemRepository;
import kr.ac.kopo20.perfect.board.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardItemRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private BoardItemRepository boardItemRepository;
	
//	@Test
	public void searchComment() {
		List<BoardItem> comments = boardItemRepository.findByBoard_idAndParent(14, 1);
		
		for (BoardItem comment : comments) {
			System.out.println(comment.toString());
		}
	}
	
	@Test
	public void searchRealBoardItems() {
		List<BoardItem> boardItems = boardItemRepository.findByBoard_idAndParent(14, 0);
		
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.toString());
		}
	}
	
//	@Test
	public void deleteBoardItem() {
		boardItemRepository.deleteById(33);
	}
	
//	@Test
	public void insertBoardItem() {
		Board board = boardRepository.findById(14).get();
		
		BoardItem boardItem = new BoardItem();
		boardItem.setTitle("추가");
		boardItem.setDate(new Date());
		boardItem.setContent("추가내용");
		boardItem.setBoard(board);
		
		List<BoardItem> boardItemList = new ArrayList<>();
		boardItemList.add(boardItem);
		board.setBoardItems(boardItemList);
		
		boardRepository.save(board);
	}
	
//	@Test 
	@Transactional
	public void updateBoardItem() {
		Optional<BoardItem> boardItem = boardItemRepository.findById(32);
		
		boardItem.ifPresent(updateBoardItem-> {
			Board board = updateBoardItem.getBoard();
			List<BoardItem> list = board.getBoardItems();
			list.remove((BoardItem)updateBoardItem);
			
			updateBoardItem.setTitle("updated Title");
			updateBoardItem.setContent("updated Content");
			
			list.add((BoardItem)updateBoardItem);
			board.setBoardItems(list);
			
			boardRepository.save(board);
			boardItemRepository.save(updateBoardItem);
			System.out.println(updateBoardItem.toString());
		});
		
	}
	
//	@Test
	@Transactional
	public void updateBoardItem2() {
		int result = boardItemRepository.updateById(32, "up", "up");
		assertEquals(result, 1);
	}
	
//	@Test
	public void updateBoardItem3() {
		BoardItem boardItem = boardItemRepository.findById(32).get();
		boardItem.setTitle("updateSuccessfully");
		boardItemRepository.save(boardItem);
	}
	
	/*
	 user.ifPresent(selectUser-> {
	 
	 });
	 
	 */
	
	
}