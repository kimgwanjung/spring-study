package kr.ac.kopo.board.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
//    @GetMapping("/post")
//    public String getPostbyNo(@RequestParam("no") int no,
//            Model model) {
//        BoardVO boardVO = boardService.getPostByNo(no);
//        model.addAttribute("boardVO", boardVO);
//        return "board/detail";
//    }
    
    @GetMapping("/board/{no}")
    public String getPostbyNo(@PathVariable("no") int no,
            Model model) {
        BoardVO boardVO = boardService.getPostByNo(no);
        model.addAttribute("boardVO", boardVO);
        return "board/detail";
    }
    
    @GetMapping("/board")
    public ModelAndView getAllBoard() {
        
        ModelAndView mav = new ModelAndView("board/boardlist");
        
        List<BoardVO> boardlist = boardService.getAllBoard();
        
        mav.addObject("boardlist", boardlist);
        return mav;
    }
    
    
    @GetMapping("/board/new")
    public String newPost(Model model) {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("기본제목");
        model.addAttribute(boardVO);
        
        return "board/writeForm";
    }
    
    @PostMapping("/board/new")
    public String postNewPost(@Valid BoardVO boardVO, BindingResult br) {
        //boardService에 일을 시킬거야~
        
        if(br.hasErrors()){
            System.out.println("에러가 있음");
            return "board/boardlist";
        }else {
            boardService.writeNewPost(boardVO);
            return "redirect:/board";
        }
        
    }
    
}
