package kr.ac.kopo.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@Controller
public class ReplyController {
    
    @Autowired
    private ReplyService replySerivce;
    
    @ResponseBody
    @PostMapping("/reply")
    public void writeReply(ReplyVO replyVO) {
        replySerivce.insertReply(replyVO);
    }
}