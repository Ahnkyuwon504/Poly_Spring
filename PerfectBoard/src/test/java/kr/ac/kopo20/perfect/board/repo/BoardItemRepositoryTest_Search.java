package kr.ac.kopo20.perfect.board.repo;



import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo20.perfect.board.domain.BoardItem;
import kr.ac.kopo20.perfect.board.repository.BoardItemRepository;
import kr.ac.kopo20.perfect.board.repository.BoardItemSpecs;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardItemRepositoryTest_Search {

	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Test
	public void searchAndPaging() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "추가");
		
		PageRequest pageable = PageRequest.of(0, 10);
		Page<BoardItem> page = boardItemRepository.findAll(pageable);
		
		for (BoardItem boardItem : page) {
			System.out.println(boardItem.toString());
		}
		
		page = boardItemRepository.findAll(BoardItemSpecs.search(filter), pageable);
		
		for (BoardItem boardItem : page) {
			System.out.println(boardItem.toString());
		}
	}
	
	
}