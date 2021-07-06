package kr.ac.kopo20.spring.board.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo20.spring.board.domain.Sample;
import kr.ac.kopo20.spring.board.repository.SampleRepository;
import kr.ac.kopo20.spring.board.repository.SampleSpecs;

@SpringBootTest
class SampleRepositoryTest {

	@Autowired
	private SampleRepository sampleRepository;
	
	@Test
	void findAll() {
		   Map<String, Object> filter = new HashMap<String, Object>();
		   filter.put("title", "첫");
		
		   PageRequest pageable = PageRequest.of(0, 10);
		   Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		   
		   for (Sample sample : page) {
			   System.out.println(sample.getTitle());
		   }
	}
//	@Test
	void find() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "두");
		
		PageRequest pageable = PageRequest.of(0, 10);
		Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		
		for (Sample sample : page) {
			System.out.println(sample.getTitle());
		}
		
	}
	
//	@Test
	void find2() {
		List<Sample> samples = sampleRepository.findAll();
		
		for (Sample sample : samples) {
			System.out.println(sample.getTitle());
		}
	}
}
