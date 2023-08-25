package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;
    public MemberVO login(LoginVO loginVO) {
        return memberDAO.login(loginVO);
    }
    public void register(MemberVO memberVO) {
        memberDAO.register(memberVO);
    }
}
