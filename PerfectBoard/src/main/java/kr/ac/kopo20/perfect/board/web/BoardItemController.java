package kr.ac.kopo20.perfect.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo20.perfect.board.domain.BoardItem;
import kr.ac.kopo20.perfect.board.repository.BoardItemRepository;
import kr.ac.kopo20.perfect.board.repository.BoardRepository;

@Controller
public class BoardItemController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	@RequestMapping(value = "/boardItem")
	public String getBoardItem(Model model,
			@RequestParam(value="key_boardId") int boardId
			) {
		String boardTitle = boardRepository.findById(boardId).get().getTitle();
		List<BoardItem> boardItems = boardItemRepository.findByBoard_id(boardId);
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardTitle", boardTitle);
		model.addAttribute("boardItems", boardItems);
		return "boardItem";
	}
	
	
	
	@RequestMapping(value = "/oneBoardItem")
	public String getOneBoardItem(Model model,
			@RequestParam(value="key_boardItemId", required=false) int boardItemId
			) {
		BoardItem boardItem = boardItemRepository.findById(boardItemId).get();
		
		model.addAttribute("boardItemTitle", boardItem.getTitle());
		model.addAttribute("boardItemDate", boardItem.getStrDate());
		model.addAttribute("boardItemContent", boardItem.getContent());
		
		return "oneBoardItem";
	}
	
	

}
