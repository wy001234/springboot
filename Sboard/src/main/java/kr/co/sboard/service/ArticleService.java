package kr.co.sboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.ArticleDAO;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO dao;
	
	public int insertArticle(ArticleVO vo) {
		
		int result = 0;
		MultipartFile file = vo.getFname();
		
		if(file.isEmpty()) {
			//파일이 첨부안했을 때
			vo.setFile(0);
			result =  dao.insertArticle(vo);
		}else {
			//파일 첨부 했을 때
			vo.setFile(1);
			result =  dao.insertArticle(vo);
			
			log.info("no :"+vo.getNo());
			
			//파일 업로드
			FileVO fileVO = new FileVO();
			fileVO.setParent(vo.getNo());
			
			fileUpload(file,fileVO);
			
			//파일 등록
			dao.insertFile(fileVO);
		}
		
		return result;
	}
	
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	
	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}
	
	public List<ArticleVO> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	
	public FileVO selectFile(int fno) {
		return dao.selectFile(fno);
	}
	
	
	
	public int updateArticle(ArticleVO vo) {
		return dao.updateArticle(vo);
	}
	
	public int deleteArticle(int no) {
		return dao.deleteArticle(no);
	}
	
	
	
	//파일 업로드
	@Value("${spring.servlet.multipart.location}")
	private String UploadPath; 
	
	public void fileUpload(MultipartFile file, FileVO fileVO) {
		//시스템 파일경로
		String path = new File(UploadPath).getAbsolutePath();
		
		// 새 파일명 생성
		String oName = file.getOriginalFilename();
		String ext = oName.substring(oName.lastIndexOf("."));
		String nName = UUID.randomUUID().toString()+ext;
		
		//파일 저장
		fileVO.setOriName(oName);
		fileVO.setNewName(nName);
		
		try {
			file.transferTo(new File(path, nName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public FileVO fileUpload(ArticleVO vo) {
		// 첨부 파일
		MultipartFile file = vo.getFname();
		FileVO fvo = null;
		
		if(!file.isEmpty()) {
			// 시스템 경로
			String path = new File(UploadPath).getAbsolutePath();
			
			// 새 파일명 생성
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			String nName = UUID.randomUUID().toString()+ext;
			
			// 파일 저장
			try {
				file.transferTo(new File(path, nName));
			} catch (IllegalStateException e) {
				log.error(e.getMessage());
			} catch (IOException e) {
				log.error(e.getMessage());
			}
			
			fvo = FileVO.builder()
					.parent(vo.getNo())
					.oriName(oName)
					.newName(nName)
					.build();
		}
		
		return fvo;
	}
	
	
	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	
	// 페이지 시작값
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	// 마지막 페이지 번호
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;			
		}else {
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	// 페이지 시작 번호
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	
	// 페이지 그룹
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
}
