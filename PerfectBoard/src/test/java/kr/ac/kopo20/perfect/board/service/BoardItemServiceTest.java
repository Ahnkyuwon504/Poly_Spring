package kr.ac.kopo20.perfect.board.service;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardItemServiceTest {

	@Autowired
	private BoardItemService boardItemService;
	
	@Test
	public void test() {
		boardItemService.test();
		
		
	}
	
	@Test
	public void testAop() {
		boardItemService.testAop();
		
	}
	
	
	
	
	
}