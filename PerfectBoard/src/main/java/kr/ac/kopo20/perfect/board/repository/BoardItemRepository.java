package kr.ac.kopo20.perfect.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
	
	// 게시글 또는 댓글 찾기
	List<BoardItem> findByBoard_idAndParent(int board_id, int parent);
	
	// 위와 동일
	Page<BoardItem> findAllByBoard_idAndParent(int board_id, int parent, Pageable pageable);
	
	// 검색조건 추가
	Page<BoardItem> findAllByBoard_idAndParent(Specification<BoardItem> spec, int board_id, int parent, Pageable pageable);
	
	// 검색
	//Optional<BoardItem> findOneByTitle(String title);
	
	//검색 및 페이징
	Page<BoardItem> findAllByTitle(String title, Pageable pageable);
	
	@Modifying
	@Query(value = "UPDATE BoardItem B SET B.title=?2, B.content=?3 WHERE B.id=?1")
	int updateById(int id, String title, String content);
	

}
