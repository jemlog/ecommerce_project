package project.finaltoyproject.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("prehandle 호출!");
        // Session 가져올때 false 옵션을 부여해야 새로운 session이 생성되지 않는다.
        HttpSession session = request.getSession(false);

        // session이 null이거나 session 내부에 값이 없다면 false를 반환
        if(session == null || session.getAttribute(SessionConst.AUTH_NAME) == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.error("무슨 에러죠? {}",ex);
    }
}
