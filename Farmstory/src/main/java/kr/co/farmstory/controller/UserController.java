package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //로그인
    @GetMapping("user/login")
    public String login(){
        return "user/login";
    }

    //회원가입
    @GetMapping("user/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("user/register")
    public  String register(UserVO vo, HttpServletRequest req){
        String regip = req.getRemoteAddr();
        vo.setRegip(regip);

        int result = service.insertUser(vo);

        return "redirect:/user/login?success="+result;
    }

    @GetMapping("user/terms")
    public String terms(Model model){
        TermsVO vo = service.selectTerms();
        model.addAttribute(vo);
        return "user/terms";
    }
}
