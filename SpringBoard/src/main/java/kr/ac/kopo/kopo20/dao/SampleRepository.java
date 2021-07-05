package kr.ac.kopo.kopo20.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo20.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
