package kr.ac.kopo20.perfect.board.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.perfect.board.domain.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	// JpaRepository가 Member를 table로 만듬
	List<Member> findByNameAndAgeLessThan(String name, int age);
	
	@Query("select t from Member t where name=:name and age < :age")
	List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
	
	List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);

}
