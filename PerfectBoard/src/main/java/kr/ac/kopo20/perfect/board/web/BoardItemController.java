package kr.ac.kopo20.perfect.board.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo20.perfect.board.domain.Board;
import kr.ac.kopo20.perfect.board.domain.BoardItem;
import kr.ac.kopo20.perfect.board.repository.BoardItemRepository;
import kr.ac.kopo20.perfect.board.repository.BoardItemSpecs;
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
		//List<BoardItem> boardItems = boardItemRepository.findByBoard_idAndParent(boardId, 0);
		
		//PageRequest pageable = PageRequest.of(0, 10);
		//Page<BoardItem> page = boardItemRepository.findAllByBoard_idAndParent(boardId, 0, pageable);
		//Page<BoardItem> page = boardItemRepository.findAll(pageable);
		
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "jk");
		
		PageRequest pageable = PageRequest.of(0, 10);
		Page<BoardItem> page = boardItemRepository.findAllByBoard_idAndParent(boardId, 0, pageable);
		//Page<BoardItem> page = boardItemRepository.findAllByBoard_idAndParent(BoardItemSpecs.search(filter), boardId, 0, pageable);
		
		model.addAttribute("board", board);
		model.addAttribute("boardItems", page.getContent());
		
		return "boardItem";
	}
	
	
	
	@RequestMapping(value = "/oneBoardItem")
	public String oneBoardItem(Model model,
			@RequestParam(value="key_count", required=false) int count,
			@RequestParam(value="key_boardItemId", required=false) int boardItemId,
			@RequestParam(value="key_commentTitle", required=false) String commentTitle,
			@RequestParam(value="key_commentContent", required=false) String commentContent
			) {
		
		BoardItem boardItem = boardItemRepository.findById(boardItemId).get();
		
		if (commentTitle != null) {
			Board board = boardRepository.findById(boardItem.getBoard().getId()).get();
			
			BoardItem newComment = new BoardItem();
			newComment.setTitle(commentTitle);
			newComment.setDate(new Date());
			newComment.setContent(commentContent);
			newComment.setBoard(board);
			newComment.setParent(boardItemId);
			
			List<BoardItem> boardItemList = new ArrayList<>();
			boardItemList.add(newComment);
			board.setBoardItems(boardItemList);
			
			boardRepository.save(board);
		}
		
		model.addAttribute("count", count);
		model.addAttribute("boardItem", boardItem);
		model.addAttribute("boardId", boardItem.getBoard().getId());
		
		////////////////////////
		////////////////////////
		////////////////////////
		////////////////////////
		List<BoardItem> comments = boardItemRepository.findByBoard_idAndParent(boardItem.getBoard().getId(), boardItemId);
		
		model.addAttribute("comments", comments);
		model.addAttribute("date", boardItemService.getDate());
		
		
		
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
	
	@RequestMapping(value = "/insertComplete")
	public String insertComplete(Model model,
			@RequestParam(value="key_title", required=false) String title,
			@RequestParam(value="key_content", required=false) String content,
			@RequestParam(value="key_boardId", required=false) int boardId
			) {
		
		Board board = boardRepository.findById(boardId).get();
		
		BoardItem boardItem = new BoardItem();
		boardItem.setTitle(title);
		boardItem.setDate(new Date());
		boardItem.setContent(content);
		boardItem.setBoard(board);
		
		List<BoardItem> boardItemList = new ArrayList<>();
		boardItemList.add(boardItem);
		board.setBoardItems(boardItemList);
		
		boardRepository.save(board);
		model.addAttribute("boardId", boardId);
		
		return "insertComplete";
	}
	
	
	
	

}
