package kr.ac.kopo.reply.dao;

import java.util.List;
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
    
    public List<ReplyVO> getReplyByBoardNo(int bno) {
        List<ReplyVO> replylist =
                sqlSessionTemplate.selectList("springboard.replyDAO.selectByBoardNo", bno);
        return replylist;
    }
    
    public void deleteReply(int replyNo) {
        sqlSessionTemplate.delete("springboard.replyDAO.deleteByNo",replyNo);
    }
    
    public ReplyVO getBoardNoByReplyNo(int replyNo) {
        ReplyVO replylist =
                sqlSessionTemplate.selectOne("springboard.replyDAO.selectByReplyNo", replyNo);
        return replylist;
    }
        
}
