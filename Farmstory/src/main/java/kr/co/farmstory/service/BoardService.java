package kr.co.farmstory.service;

import kr.co.farmstory.dao.BoardDAO;
import kr.co.farmstory.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardDAO dao;

    public BoardVO selectArticle(int no) {

        return dao.selectArticle(no);
    }

    //게시글 리스트
    public List<BoardVO> selectArticles(String cate, int start) {
        return dao.selectArticles(cate, start);
    }

    //게시글 등록
    public int insertArticle(BoardVO vo){
        return  dao.insertArticle(vo);
    };
    
    //조회수 증가
    public int selectCountTotal() {
        return dao.selectCountTotal();
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
