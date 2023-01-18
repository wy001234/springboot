package kr.co.sboard.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.ch07.vo.User1VO;
import kr.co.sboard.dao.ArticleDAO;
import kr.co.sboard.repository.ArticleRepo;
import kr.co.sboard.vo.ArticleVO;


@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO dao;
	
	@Autowired
	private ArticleRepo repo;
	
	public void insertArticle(ArticleVO vo) {
		repo.save(vo);
	};
	
	public ArticleVO selectArticle(String no) {
		ArticleVO article = repo.findById(no).get();
		
		return article;
	};
	
	public List<ArticleVO> selectArticles(){
		List<ArticleVO> article = repo.findAll();
		
		return article;
	};
	
	public void updateArticle(ArticleVO vo) {
		repo.save(vo);
	};
	
	public void deleteArticle(String no) {
		
		repo.deleteById(no);
	};

}
