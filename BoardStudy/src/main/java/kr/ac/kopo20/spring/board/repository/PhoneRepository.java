package kr.ac.kopo20.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.spring.board.domain.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{

}
