package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.user.dto.ProfileResponseDto;
import project.finaltoyproject.util.exeption.SessionRemoveException;
import project.finaltoyproject.web.auth.SessionConst;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.LoginDto;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.service.UserService;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;
import project.finaltoyproject.util.exeption.UserNotExistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    // TODO: 회원가입, 로그인, 로그아웃 구현

    @PostMapping("/auth/signup")
    public Long signup(@RequestBody UserRequestDto userRequestDto, BindingResult bindingResult) throws DuplicatedEmailException {

        // 중복되는 회원 체크
        userService.findByEmailCheckDuplicated(userRequestDto.getEmail());

        // 기존에 회원이 없다면 회원 가입 진행
        User savedUser = userService.save(new User(userRequestDto));
        return savedUser.getId();
    }


    @PostMapping("/auth/login")
    public String login(@RequestBody LoginDto loginDto, HttpServletRequest request) throws UserNotExistException {

        // login user 찾기
        User findUser = userService.findByEmail(loginDto.getEmail(),loginDto.getPassword());
        if(findUser == null)
        {
            throw new UserNotExistException("존재하지 않는 회원입니다.");
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.AUTH_NAME,findUser);
        return "login success";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "logout success";
    }

    @GetMapping("/auth/health")
    public String healthCheck()
    {
        return "login";
    }

    @GetMapping("/auth/profile")
    public ProfileResponseDto profileInfo(@Login User loginUser) throws Exception
    {
        User user = userService.findById(loginUser.getId());
        if(user == null)
        {
            throw new SessionRemoveException("인증되지 않은 사용자입니다.");
        }

        return new ProfileResponseDto(user);
    }
}
