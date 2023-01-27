package kr.co.farmstory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "board_article")
public class BoardEntity {

	@Id
	private int no;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;

	
}
