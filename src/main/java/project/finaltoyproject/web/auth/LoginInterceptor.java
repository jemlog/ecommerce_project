package project.finaltoyproject.web.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import project.finaltoyproject.util.exeption.SessionRemoveException;

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
            // api 통신에서 errorField를 응답함으로써 클라이언트에 동작을 명령
            throw new SessionRemoveException("로그아웃 되었습니다.");
        }
        return true;
    }

}
