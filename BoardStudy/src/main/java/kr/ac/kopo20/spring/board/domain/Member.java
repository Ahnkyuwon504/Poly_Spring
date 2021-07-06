package kr.ac.kopo20.spring.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")
	private List<Phone> phones;
	
	public List<Phone> getPhones() {
		if (phones == null) {
			phones = new ArrayList<Phone>();
		}

		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public Member() {
		
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public void addPhone(Phone p) {
		List<Phone> phones = getPhones();
		phones.add(p);
	}
	
	/*
	 * public Member() {
	 * 
	 * }
	 * 
	 * public Member(String name, int age) { this.name = name; this.age = age; }
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
