package kr.ac.kopo20.perfect.board.repo;

import static org.junit.jupiter.api.Assertions.*;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo20.perfect.board.domain.Member;
import kr.ac.kopo20.perfect.board.domain.Phone;
import kr.ac.kopo20.perfect.board.repository.MemberRepository;
import kr.ac.kopo20.perfect.board.repository.PhoneRepository;

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

// 생성
//	@Test
	public void create() {
		Member member1 = new Member("첫 번째 친구", 30);
		Member member2 = new Member("두 번째 친구", 30);

		Phone phone1 = new Phone();
		phone1.setNo("나나");
		phone1.setMember(member1);

		Phone phone2 = new Phone();
		phone2.setNo("가가");
		phone2.setMember(member1);

		Phone phone3 = new Phone();
		phone3.setNo("다다");
		phone3.setMember(member1);

		List<Phone> list = new ArrayList<Phone>();
		list.add(phone1);
		list.add(phone2);
		list.add(phone3);

		member1.setPhones(list);

		memberRepository.save(member1);
		memberRepository.save(member2);

		for (Member member : memberRepository.findAll()) {
			System.out.println(member.toString());
		}

		for (Phone phone : phoneRepository.findAll()) {
			System.out.println(phone.toString());
		}
	}

// 아이디로 지우기
//	@Test
	public void delete() {
		memberRepository.deleteById(54);
	}

// 싹다 지우기
//	@Test
	public void deleteAll() {
		memberRepository.deleteAll();
		phoneRepository.deleteAll();
	}
	
// 부모로 자식 찾기
	@Test
	@Transactional
	public void findChild() {
		Optional<Member> optionalMember = memberRepository.findById(5);

		Member member = new Member();
		if (optionalMember.isPresent()) {
			member = optionalMember.get();
			System.out.println(member.toString());
		}
		
		//Member에서 getPhones 이용해서 가져오는것
		for (Phone phone : member.getPhones()) {
			System.out.println(phone.toString());
		}
		  
		// 내가만든것
		/*
		List<Phone> phones = phoneRepository.findByMember_id(member.getId());

		for (Phone phone : phones) {
			System.out.println(phone.toString());
		}
		*/
	}

//	@Test
	public void findNoChild() {
		Optional<Member> optionalMember = memberRepository.findById(6);

		Member member = new Member();
		if (optionalMember.isPresent()) {
			member = optionalMember.get();
			System.out.println(member.toString());
		}

		for (Phone phone : member.getPhones()) {
			System.out.println(phone.toString());
		}

	}

//	@Test
	public void findParent() {
		Optional<Phone> optionalPhone = phoneRepository.findById(7);

		Phone phone = new Phone();


		if (optionalPhone.isPresent()) {
			phone = optionalPhone.get();
			System.out.println(phone.toString());
		}

		Member member = phone.getMember();

		System.out.println(member.toString());

	}

//	@Test
	public void oneToMany_TwoWay() {
		Member newMember = new Member("새로운 친구", 30);

		// Phone phone1 = new Phone("000");
		// first.addPhone(phone1);

		// Phone phone2 = new Phone();
		// phone2.setNo("111");
		// phone2.setMember(first);

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
