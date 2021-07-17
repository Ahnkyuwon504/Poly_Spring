package kr.ac.kopo20.first.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo20.first.project.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
