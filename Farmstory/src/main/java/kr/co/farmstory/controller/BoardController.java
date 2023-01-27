package kr.co.farmstory.controller;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("board/list")
    public String list(Model model, String group, String cate, String pg){
        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = service.selectCountTotal();
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

        List<BoardVO> boards = service.selectArticles(cate, start);

        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify() {
        return "board/modify";
    }

    @GetMapping("board/view")
    public String view() {
        return "board/view";
    }

    @GetMapping("board/write")
    public String write(Model model, String group, String cate){

        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/write";
    }

    @PostMapping("board/write")
    public String write(BoardVO vo, HttpServletRequest req){


        String regip = req.getRemoteAddr();
        vo.setRegip(regip);

        service.insertArticle(vo);
        return "redirect:index";
    }

}
