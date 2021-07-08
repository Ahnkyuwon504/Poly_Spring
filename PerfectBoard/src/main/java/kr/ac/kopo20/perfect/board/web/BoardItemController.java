package kr.ac.kopo20.perfect.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo20.perfect.board.domain.Board;
import kr.ac.kopo20.perfect.board.domain.BoardItem;
import kr.ac.kopo20.perfect.board.repository.BoardItemRepository;
import kr.ac.kopo20.perfect.board.repository.BoardRepository;
import kr.ac.kopo20.perfect.board.service.BoardItemService;

@Controller
public class BoardItemController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	@Autowired
	BoardItemService boardItemService;
	
	@RequestMapping(value = "/boardItem")
	public String getBoardItem(Model model,
			@RequestParam(value="key_boardId") int boardId
			) {
		
		Board board = boardRepository.findById(boardId).get();
		List<BoardItem> boardItems = boardItemRepository.findByBoard_id(boardId);
		
		model.addAttribute("board", board);
		model.addAttribute("boardItems", boardItems);
		return "boardItem";
	}
	
	
	
	@RequestMapping(value = "/oneBoardItem")
	public String oneBoardItem(Model model,
			@RequestParam(value="key_count", required=false) int count,
			@RequestParam(value="key_boardItemId", required=false) int boardItemId
			) {
		BoardItem boardItem = boardItemRepository.findById(boardItemId).get();
		
		model.addAttribute("count", count);
		model.addAttribute("boardItem", boardItem);
		model.addAttribute("boardId", boardItem.getBoard().getId());
		
		return "oneBoardItem";
	}
	
	@RequestMapping(value = "/updateComplete")
	public String updateComplete(Model model,
			@RequestParam(value="key_title", required=false) String title,
			@RequestParam(value="key_content", required=false) String content,
			@RequestParam(value="key_boardItemId", required=false) int boardItemId
			) {
		
		BoardItem boardItem = boardItemRepository.findById(boardItemId).get();
		
		boardItem.setTitle(title);
		boardItem.setContent(content);
		boardItemRepository.save(boardItem);
		
		model.addAttribute("boardId", boardItem.getBoard().getId());
		return "updateComplete";
	}
	
	@RequestMapping(value = "/deleteComplete")
	public String deleteComplete(Model model,
			@RequestParam(value="key_boardItemId", required=false) int boardItemId
			) {
		int boardId = boardItemRepository.findById(boardItemId).get().getBoard().getId();
		boardItemRepository.deleteById(boardItemId);
		
		model.addAttribute("boardId", boardId);
		return "deleteComplete";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(Model model,
			@RequestParam(value="key_count", required=false) int count,
			@RequestParam(value="key_boardId", required=false) int boardId
			) {
		
		model.addAttribute("count", count);
		model.addAttribute("boardId", boardId);
		model.addAttribute("date", boardItemService.getDate());
		return "insert";
	}
	
	
	
	

}
