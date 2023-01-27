package kr.co.farmstory.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardVO {

    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private String fname;
    private int file;
    private int hit;
    private String uid;
    private String regip;
    private String rdate;
    private String nick;




    public String getRdate() {
        return rdate.substring(2, 10);
    }


}
