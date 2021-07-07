package kr.ac.kopo20.perfect.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.perfect.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>, JpaSpecificationExecutor<Board> {
	

}
