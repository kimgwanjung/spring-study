package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAO {
    
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
    public MemberVO login(LoginVO loginVO) {
        MemberVO memberVO =
                sqlSessionTemplate.selectOne("springboard.member.dao.MemberDAO.login", loginVO);
        return memberVO;
    }
    
    public void register(MemberVO memberVO) {
        sqlSessionTemplate.insert("springboard.member.dao.MemberDAO.register", memberVO);
    }
}
