package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import kr.co.ch09.repository.MemberRepo;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService{
	
	@Autowired
	private MemberRepo repo;
	
	
	public void insertMember(MemberVO vo) {
		repo.save(vo);
	}
	
	public MemberVO selectMember(String uid) {
		MemberVO vo = repo
		
	};
	public List<MemberVO> selectMembers();
	public void updatetMember(User1VO vo);
	public void deleteMember(String uid);
	
}
