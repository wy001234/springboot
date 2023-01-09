package kr.co.ch06.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch06.vo.UserVO;

@Controller
public class MainController {

	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
		
		String tit = "Sprong boot";
		String name = "Thymeleaf~";
		
		UserVO user1 = new UserVO();
		user1.setUid("a101");
		user1.setName("홍길동");
		user1.setHp("010-1234-1001");
		user1.setAge(21);
		
		UserVO user2 = null;
		
		List<UserVO> users = new ArrayList<>();
		users.add(new UserVO("a101","김유신","010-1234-1001",21));
		users.add(new UserVO("a102","김춘추","010-1234-1001",22));
		users.add(new UserVO("a103","장보고","010-1234-1001",23));
		users.add(new UserVO("a104","강삼찬","010-1234-1001",24));
		users.add(new UserVO("a105","이순신","010-1234-1001",25));
		
		
		model.addAttribute("tit", tit);
		model.addAttribute("name", name);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		model.addAttribute("users", users);
		
		return "/index";
	}
}
