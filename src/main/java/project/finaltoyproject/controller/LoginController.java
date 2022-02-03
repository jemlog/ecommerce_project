package project.finaltoyproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.auth.SessionConst;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.LoginDto;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.domain.user.repository.UserRepository;
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
        User findUser = userService.findByEmailForLogin(loginDto.getEmail(),loginDto.getPassword());
        if(findUser == null)
        {
            throw new UserNotExistException("존재하지 않는 회원입니다.");
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.AUTH_NAME,findUser.getId());
        return "login success";
    }
//
//    @GetMapping("/auth/logout")
//    public String logout()
//    {
//
//    }
}
