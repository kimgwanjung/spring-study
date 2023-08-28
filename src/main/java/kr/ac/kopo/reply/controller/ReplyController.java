package kr.ac.kopo.reply.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@Controller
public class ReplyController {
    
    @Autowired
    private ReplyService replyService;
    
    @ResponseBody
    @PostMapping("/reply")
    public void writeReply(ReplyVO replyVO) {
        replyService.insertReply(replyVO);
    }
    
    @ResponseBody
    @GetMapping("/reply/{bno}")
    public List<ReplyVO> getAllReply(@PathVariable("bno") int bno) {
        List<ReplyVO> replylist = replyService.getReplyByBoardNo(bno);
        for(ReplyVO reply : replylist) {
            System.out.println(reply);
        }
        return replylist;
    }
    
    
    @ResponseBody
    @DeleteMapping("/reply/{replyNo}")
    public void deleteReply(@PathVariable("replyNo") int replyNo) {
        replyService.deleteReply(replyNo);
    }
}
