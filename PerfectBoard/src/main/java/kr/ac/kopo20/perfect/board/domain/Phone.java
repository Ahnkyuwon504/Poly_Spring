package kr.ac.kopo20.perfect.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String no;

	@ManyToOne(optional = false)
	@JoinColumn(name = "member_id") // field명
	private Member member; // mapping의 근거

	public Phone() {
	  
	}
	  
	public Phone(String no) {
		  this.no = no;
	}
	

	public String getNo() {
		return no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", no=" + no + "]";
	}
	
	

}
