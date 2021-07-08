package kr.ac.kopo20.perfect.board.repo;

import static org.junit.jupiter.api.Assertions.fail;

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
class BoardRepositoryTest {

//	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private BoardItemRepository boardItemRepository;
	
//	@Test
	public void updateBoard() {
		Board board = boardRepository.findById(14).get();
		board.setTitle("업데이트한 첫 번째 게시판");
		boardRepository.save(board);
	}
	
	
//	@Test 
	public void createBoardItem() {
		Board board = boardRepository.findById(14).get();
		
		BoardItem boardItem = new BoardItem();
		boardItem.setTitle("첫 번째 게시판의 다섯 번째 게시물");
		boardItem.setDate(new Date());
		boardItem.setContent("내용");
		boardItem.setBoard(board);
		
		List<BoardItem> list = new ArrayList<>();
		list.add(boardItem);
		board.setBoardItems(list);
		
		boardRepository.save(board);
	}
	
	
	
	@Test
	public void createBoardAndBoardItem() {
		// 부모생성
		Board board1 = new Board();
		board1.setTitle("첫 번째 게시판");
		
		// 자식생성 및 부모 알려줌
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("첫 번째 게시판의 첫 번째 게시물");
		boardItem1.setContent("내용");
		boardItem1.setBoard(board1);
		boardItem1.setDate(new Date());
		
		BoardItem boardItem2 = new BoardItem();
		boardItem2.setTitle("첫 번째 게시판의 두 번째 게시물");
		boardItem2.setContent("내용");
		boardItem2.setBoard(board1);
		boardItem2.setDate(new Date());
		
		BoardItem boardItem3 = new BoardItem();
		boardItem3.setTitle("첫 번째 게시판의 세 번째 게시물");
		boardItem3.setContent("내용");
		boardItem3.setBoard(board1);
		boardItem3.setDate(new Date());
		
		BoardItem boardItem4 = new BoardItem();
		boardItem4.setTitle("첫 번째 게시판의 네 번째 게시물");
		boardItem4.setContent("내용");
		boardItem4.setBoard(board1);
		boardItem4.setDate(new Date());
		
		// 자식들을 담을 쟁반 생성, 사뿐히 삽입
		List<BoardItem> list1 = new ArrayList<>();
		list1.add(boardItem1);
		list1.add(boardItem2);
		list1.add(boardItem3);
		list1.add(boardItem4);
		
		// 부모에 자식들을 담은 쟁반을 알려줌
		board1.setBoardItems(list1);
		
		// 부모생성
		Board board2 = new Board();
		board2.setTitle("두 번째 게시판");
		
		// 자식생성 및 부모 알려줌
		BoardItem boardItem5 = new BoardItem();
		boardItem5.setTitle("두 번째 게시판의 첫 번째 게시물");
		boardItem5.setContent("내용");
		boardItem5.setBoard(board2);
		boardItem5.setDate(new Date());
		
		BoardItem boardItem6 = new BoardItem();
		boardItem6.setTitle("두 번째 게시판의 두 번째 게시물");
		boardItem6.setContent("내용");
		boardItem6.setBoard(board2);
		boardItem6.setDate(new Date());
		
		// 자식들을 담을 쟁반 생성, 사뿐히 삽입
		List<BoardItem> list2 = new ArrayList<>();
		list2.add(boardItem5);
		list2.add(boardItem6);
		
		// 부모에 자식들을 담은 쟁반을 알려줌
		board2.setBoardItems(list2);
		
		// 서로 알았으니 부모 저장
		boardRepository.save(board1);
		boardRepository.save(board2);
		
		
	}
	
//	@Test
	@Transactional
	public void createDate() {
		// 부모생성
		Board board1 = boardRepository.getById(1);
		
		// 자식생성 및 부모 알려줌
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("날짜를 달아준 첫 번째 게시물");
		boardItem1.setDate(new Date(20210707));
		boardItem1.setBoard(board1);
		
		List<BoardItem> list = board1.getBoardItems();
		list.add(boardItem1);
		
		
		board1.setBoardItems(list);
		
		for (BoardItem boardItem : list) {
			System.out.println(boardItem.toString());
		}
		
		// 서로 알았으니 부모 저장
		boardRepository.save(board1);
	}
	
//	@Test
	public void delete() {
		boardItemRepository.deleteAll();
		boardRepository.deleteAll();
	}
	
//    @Test
    @Transactional
	public void findChild() {
    	Optional<Board> optionalBoard = boardRepository.findById(1);
    	
    	Board board = new Board();
    	
    	if (optionalBoard.isPresent()) {
    		board = optionalBoard.get();
    	}
    	
    	for (BoardItem boardItem : board.getBoardItems()) {
    		System.out.println(boardItem.toString());
    		System.out.println(boardItem.getId());
    	}
	}
    
//    @Test
    public void findParent() {
    	Optional<BoardItem> optionalBoardItem = boardItemRepository.findById(7);
    	
    	BoardItem boardItem = new BoardItem();
    	
    	if (optionalBoardItem.isPresent()) {
    		boardItem = optionalBoardItem.get();
    	}
    	
    	System.out.println(boardItem.getBoard().getId());
    }
}
