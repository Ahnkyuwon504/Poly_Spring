package kr.ac.kopo20.perfect.board.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.perfect.board.domain.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{
// JpaRepository가 Phone를 table로 만듬
	List<Phone> findByMember_id(int member_id);
}
