package kr.ac.kopo.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import kr.ac.kopo.member.vo.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("TestInterceptor prehandle()");
        System.out.println(request.getServletPath() + request.getContextPath() + request.getQueryString() + handler);
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO)session.getAttribute("currentUser"); // 정상 로그인 시에 세션을 등록했다.
        
        session.setAttribute("dest", request.getServletPath());
        if(memberVO != null) {
            System.out.println("로그인 되어있음");
            return true;
        }else {
            
            System.out.println("로그인 안되어있으면 login.jsp로");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        // TODO Auto-generated method stub
        // 로그인 안되어 있는 경우에는 return false하고,
        // redirect를 해서 login 페이지로 보내야겠디.
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("TestInterceptor posthandle()");
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    // loginIntercepter 라는 이름으로 인스턴스를 생성함.
    
    
    
    
    
}

