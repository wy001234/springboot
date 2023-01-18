package kr.co.ch09.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class MemberVO {
	
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private String pos;
	private String dep;
	private String rdate;

}
