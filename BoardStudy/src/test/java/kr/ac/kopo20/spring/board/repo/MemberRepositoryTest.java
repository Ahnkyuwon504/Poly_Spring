package kr.ac.kopo20.spring.board.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo20.spring.board.domain.Member;
import kr.ac.kopo20.spring.board.domain.Phone;
import kr.ac.kopo20.spring.board.repository.MemberRepository;
import kr.ac.kopo20.spring.board.repository.PhoneRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

//	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Test
	public void oneToMany_TwoWay() {
		Member newMember = new Member("새로운 친구", 30);
		
		//Phone phone1 = new Phone("000");
		//first.addPhone(phone1);
		
		//Phone phone2 = new Phone();
		//phone2.setNo("111");
		//phone2.setMember(first);
		
		List<Phone> list = new ArrayList<Phone>();
		Phone phone1 = new Phone();
		phone1.setNo("나나");
		phone1.setMember(newMember);
		
		Phone phone2 = new Phone();
		phone2.setNo("가가");
	    phone2.setMember(newMember);
	    
	    Phone phone3 = new Phone();
	    phone3.setNo("다다");
	    phone3.setMember(newMember);
	    
		list.add(phone1);
		list.add(phone2);
		
		newMember.setPhones(list);
		newMember.addPhone(phone3);
		
		memberRepository.save(newMember);
		
		for (Phone p : phoneRepository.findAll()) {
			System.out.println(p.toString());
		}
				
	}

}
