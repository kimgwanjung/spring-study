package kr.ac.kopo.reply.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyService {
    @Autowired
    private ReplyDAO replyDAO;
    @Autowired
    private BoardDAO boardDAO;
    @Transactional
    public void insertReply(ReplyVO replyVO) {
        //1. 댓글수 1 증가 -> t_board
        boardDAO.increaseCount(replyVO.getBoardNo());
        replyDAO.insertReply(replyVO);
    }
    
    public List<ReplyVO> getReplyByBoardNo(int bno) {
        List<ReplyVO> replylist = replyDAO.getReplyByBoardNo(bno);
        return replylist;
    }
    
    @Transactional
    public void deleteReply(int replyNo) {
        //1. 댓글수 1 감소 -> t_board 
        ReplyVO reply = replyDAO.getBoardNoByReplyNo(replyNo);
        int no = reply.getBoardNo();
        boardDAO.decreaseCount(no);
        replyDAO.deleteReply(replyNo);
    }

}
