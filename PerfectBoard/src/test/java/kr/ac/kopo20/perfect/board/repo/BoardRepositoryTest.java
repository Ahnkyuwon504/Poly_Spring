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
	
	@Test 
	public void board() {
		List<Board> boards = boardRepository.findAll();
		
		for (Board board : boards) {
			System.out.println(board.toString());
		}
	}
	
	
	
//	@Test
	public void create() {
		// 부모생성
		Board board1 = new Board();
		board1.setTitle("세 번째 게시판");
		
		// 자식생성 및 부모 알려줌
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("날짜 번째 게시물");
		boardItem1.setBoard(board1);
		boardItem1.setDate(new Date());
		
		// 자식들을 담을 쟁반 생성, 사뿐히 삽입
		List<BoardItem> list = new ArrayList<>();
		list.add(boardItem1);
		
		// 부모에 자식들을 담은 쟁반을 알려줌
		board1.setBoardItems(list);
		
		// 서로 알았으니 부모 저장
		boardRepository.save(board1);
		
		
		
		
		
		
		
		
		
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
	
	@Test
	public void delete() {
		boardItemRepository.deleteById(7);
	}
	
    @Test
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
    
    @Test
    public void findParent() {
    	Optional<BoardItem> optionalBoardItem = boardItemRepository.findById(7);
    	
    	BoardItem boardItem = new BoardItem();
    	
    	if (optionalBoardItem.isPresent()) {
    		boardItem = optionalBoardItem.get();
    	}
    	
    	System.out.println(boardItem.getBoard().getId());
    }
}
