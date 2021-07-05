package kr.ac.kopo.kopo20.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo20.domain.Sample;

@Mapper
@Repository
public interface SampleMapper {
	List<Sample> findAll();
}
