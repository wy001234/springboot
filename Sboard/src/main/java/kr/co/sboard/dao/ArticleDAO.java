package kr.co.sboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.ArticleVO;

@Mapper
@Repository
public interface ArticleDAO {
	
	public void insertArticle(ArticleVO vo);
	
	public ArticleVO selectArticle(String no);
	
	public List<ArticleVO> selectArticles();
	
	public void updateArticle(ArticleVO vo);
	
	public void deleteArticle(String no);

}
