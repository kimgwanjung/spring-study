package kr.ac.kopo.member.controller;

import java.lang.reflect.Member;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("currentUser")
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/login")
    public String loginForm(Model model) {
        LoginVO loginVO = new LoginVO();
        model.addAttribute(loginVO);
        return "member/loginForm";
    }
    
    @PostMapping("/login")
    public String loginProcess(@Valid LoginVO loginVO , BindingResult bs, Model model, HttpSession session) {
        if(bs.hasErrors()) { // Error일 떼,
            return "/member/loginForm"; // 다시 로그인하세요.
        }else { // null이 없을 때.
            MemberVO memberVO = memberService.login(loginVO);
            
            if(memberVO == null) { //id와 password 틀린경우, 사용자 없음.
                System.out.println("ID/PASSWORD 불일치");
                model.addAttribute("msg", "id와 password를 다시 확인해라");
                return "member/loginForm";

            }else {
                System.out.println("post login이 완료 : " + memberVO);
                
                // session에 등록 @SessionAttributes("currentUser")
                model.addAttribute("currentUser", memberVO);
                return "redirect:/";
            }
            
        }

    }
    
    //@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currentUser");
        
        return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout2(SessionStatus sessionStatus) {
        //session.removeAttribute("currentUser");
        sessionStatus.setComplete();
        return "redirect:/";
    }
    
    
    @GetMapping("/register")
    public String registerForm(Model model) {
        MemberVO memberVO = new MemberVO();
        model.addAttribute(memberVO);
        return "member/registerForm";
    }
    
    @PostMapping("/register")
    public String registerProcess(@Valid MemberVO memberVO, BindingResult bs, Model model) {
        if(bs.hasErrors()) {
            return "/member/registerForm";
        }else {
            memberService.register(memberVO); 
            return "redirect:/login";
        }
        
    }
}
