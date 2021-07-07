package kr.ac.kopo20.perfect.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.perfect.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem>{
//	JpaRepository가 BoardItem을 table로 만듬
	// 대문자 기준으로 쪼개서 언더바 삽입..알아서한다.

}
