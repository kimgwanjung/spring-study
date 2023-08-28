package kr.ac.kopo.reply.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class ReplyDAO {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public void insertReply(ReplyVO replyVO) {
        sqlSessionTemplate.insert("springboard.replyDAO.insertReply", replyVO);
    }
}
