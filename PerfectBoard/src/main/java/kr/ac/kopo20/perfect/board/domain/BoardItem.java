package kr.ac.kopo20.perfect.board.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class BoardItem {
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String title;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column
	private String content;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="board_id")
	private Board board;
	
	@Column
	private int parent;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "BoardItem [title=" + title + ", date=" + date + ", content=" + content + ", parent=" + parent + "]";
	}
	
	public String getStrDate() {
        return  new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(this.date);
}
	

	
	

}
