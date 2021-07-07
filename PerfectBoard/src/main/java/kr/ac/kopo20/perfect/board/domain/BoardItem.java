package kr.ac.kopo20.perfect.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoardItem {
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String title;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="board_id")
	private Board board;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	

}
