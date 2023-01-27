package kr.co.farmstory.dao;

import kr.co.farmstory.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDAO {

    //게시글등록
    public int insertArticle(BoardVO vo);

    //파일등록
    public int insertFile();

    //게시글 조회수 증가
    public int selectCountTotal();

    //게시글 보기
    public BoardVO selectArticle(int no);

    //게시글 목록
    public List<BoardVO> selectArticles(String arg0, int arg1);

    //파일 선택
    public String selectFile(int fno);

    //파일다운로드
    public int updateFileDownload(int fno);


    //게시글 수정
    public int updateArticle(BoardVO vo);

    //게시글 삭제
    public int deleteArticle(int no);

}
