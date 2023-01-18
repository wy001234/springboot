package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.service.MemberService;
import kr.co.ch09.vo.MemberVO;
import kr.co.ch09.vo.User1VO;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	
	@ResponseBody
	@PostMapping("/user1")
	public List<MemberVO> register(MemberVO vo) {
		service.insertUser(vo);	
		return service.selectUser1s();
	}

}
