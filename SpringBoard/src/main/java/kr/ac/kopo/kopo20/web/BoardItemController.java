package kr.ac.kopo.kopo20.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.kopo20.domain.BoardItem;
import kr.ac.kopo.kopo20.service.BoardItemService;
import kr.ac.kopo.kopo20.service.ConstValue;

@Controller
public class BoardItemController {

	@Autowired
	private BoardItemService boardItemService;

	@RequestMapping(value = "/boardItem")
	public String boardItem(Model model, 
			@RequestParam("key_boardid") int boardId,
			@RequestParam(value = "key_search", required=false) String search,
			@RequestParam(value = "from", required=false) String strfrom,
			@RequestParam(value = "to", required=false) String strto
			) {
		
		int onePage = ConstValue.onePage;
		int boardItemHowMany = boardItemService.selectAll(boardId).size();
		String keyword = boardItemService.getKeyWord(search);
		
		int from = boardItemService.getFromAndTo(strfrom, strto, boardItemHowMany, onePage)[0];
		int to = boardItemService.getFromAndTo(strfrom, strto, boardItemHowMany, onePage)[1];

		List<BoardItem> boardItemList = boardItemService.selectAll(boardId, keyword);
		
		// 페이징처리 관련
		int previousPageFrom = from - onePage;
		int previousPageTo = from - 1;
		int nextPageFrom = from + onePage;
		int nextPageTo = from + 2 * onePage - 1;
		int nowPageMax = boardItemService.selectAll(boardId, keyword).size() / onePage + 1;

		model.addAttribute("boardId", boardId);
		model.addAttribute("boardItemList", boardItemList);
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		
		model.addAttribute("previousPageFrom", previousPageFrom);
		model.addAttribute("previousPageTo", previousPageTo);
		model.addAttribute("nextPageFrom", nextPageFrom);
		model.addAttribute("nextPageTo", nextPageTo);
		model.addAttribute("nowPageMax", nowPageMax);
		model.addAttribute("onePage", onePage);

		return "boardItem";
	}

	@RequestMapping(value = "/oneBoardItem", method = RequestMethod.POST)
	public String oneBoardItem(Model model, 
			@RequestParam(value = "key_itemid") int itemId,
			@RequestParam(value = "key_boardid") int boardId, 
			@RequestParam(value = "key_commentTitle", required=false) String commentTitle,
			@RequestParam(value = "key_commentDate", required = false) String commentDate,
			@RequestParam(value = "key_commentContent", required = false) String commentContent, 
			@RequestParam("key_count") int count
			) {

		BoardItem boardItem = boardItemService.selectOne(itemId);
		boardItem.setComments(boardItemService.getAllComments(boardItem));
		
		if (commentTitle != null) { 
			BoardItem newComment = new BoardItem(commentTitle, commentDate, commentContent, boardId); 
			boardItemService.createComment(boardItem, newComment); 
		}
		 
		List<BoardItem> comments = boardItem.getComments();

		model.addAttribute("date", boardItemService.getDate());
		model.addAttribute("itemId", itemId);
		model.addAttribute("count", count);
		model.addAttribute("title", boardItem.getTitle());
		model.addAttribute("date", boardItemService.getDate());
		model.addAttribute("content", boardItem.getContent());
		model.addAttribute("boardId", boardId);

		model.addAttribute("comments", comments);

		return "oneBoardItem";
	}
	
	@RequestMapping(value = "/deleteComplete", method = RequestMethod.POST)
	public String deleteComplete(Model model, 
			@RequestParam("key_itemid") int itemId,
			@RequestParam("key_boardid") int boardId
			) {

		boardItemService.delete(boardItemService.selectOne(itemId));
		model.addAttribute("boardId", boardId);

		return "deleteComplete";
	}
	
	@RequestMapping(value = "/updateComplete", method = RequestMethod.POST)
	public String updateComplete(Model model, 
			@RequestParam("key_itemid") int itemId,
			@RequestParam("key_title") String title,
			@RequestParam("key_content") String content,
			@RequestParam("key_boardid") int boardId
			) {
		
		boardItemService.update(boardItemService.selectOne(itemId), title, content);
		model.addAttribute("boardId", boardId);
		
		return "updateComplete";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, 
			@RequestParam("key_boardid") int boardId,
			@RequestParam("key_insert") int count
			) {
		
		model.addAttribute("count", count);
		model.addAttribute("boardId", boardId);
		model.addAttribute("date", boardItemService.getDate());
		
		return "insert";
	}
	
	@RequestMapping(value = "/insertComplete", method = RequestMethod.POST)
	public String insertComplete(Model model, 
			@RequestParam("key_boardid") int boardId,
			@RequestParam("key_title") String title,
			@RequestParam("key_date") String date,
			@RequestParam("key_content") String content
			) {
		
		boardItemService.create(new BoardItem(title, date, content, boardId));
		model.addAttribute("boardId", boardId);
		
		return "insertComplete";
	}
}
