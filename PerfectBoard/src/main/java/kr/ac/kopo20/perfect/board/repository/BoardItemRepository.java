package kr.ac.kopo20.perfect.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.perfect.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem>{
//	JpaRepository가 BoardItem을 table로 만듬
	// 대문자 기준으로 쪼개서 언더바 삽입..알아서한다.
	List<BoardItem> findByBoard_id(int board_id);
	
	@Modifying
	@Query(value = "UPDATE BoardItem B SET B.title=?2, B.content=?3 WHERE B.id=?1")
	int updateById(int id, String title, String content);
	

}
