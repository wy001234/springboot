package kr.co.sboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;

@Mapper
@Repository
public interface ArticleDAO {
	
	//게시글등록
	public int insertArticle(ArticleVO vo);
	
	//파일등록
	public int insertFile(FileVO vo);
	
	//게시글 조회수 증가
	public int selectCountTotal();
	
	//게시글 보기
	public ArticleVO selectArticle(int no);
	
	//게시글 목록
	public List<ArticleVO> selectArticles(int start);
	
	//파일 선택
	public FileVO selectFile(int fno);
	
	//파일다운로드
	public int updateFileDownload(int fno);
	
	
	//게시글 수정
	public int updateArticle(ArticleVO vo);
	
	
	//게시글 삭제
	public int deleteArticle(int no);
	

}
