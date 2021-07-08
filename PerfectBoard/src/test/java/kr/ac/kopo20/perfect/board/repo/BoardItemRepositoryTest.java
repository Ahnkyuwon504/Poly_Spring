package kr.ac.kopo20.perfect.board.repo;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

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
	public void deleteBoardItem() {
		boardItemRepository.deleteById(33);
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