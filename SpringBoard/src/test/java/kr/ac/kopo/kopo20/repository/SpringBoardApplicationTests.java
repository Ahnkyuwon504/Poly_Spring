package kr.ac.kopo.kopo20.repository;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.kopo20.dao.SampleRepository;
import kr.ac.kopo.kopo20.dao.SampleSpecs;
import kr.ac.kopo.kopo20.domain.Sample;

@SpringBootTest
class SpringBoardApplicationTests {

	@Autowired
	private SampleRepository sampleRepository;
	
	@Test
	void findAll() {
		   Map<String, Object> filter = new HashMap<String, Object>();
		   filter.put("title", "첫 번째 샘플");
		
		   PageRequest pageable = PageRequest.of(0, 10);
		   Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		   
		   for (Sample sample : page) {
			   System.out.println(sample.getTitle());
		   }
	}
}
