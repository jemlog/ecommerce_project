package project.finaltoyproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.domain.user.repository.UserRepository;
import project.finaltoyproject.service.UserService;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    // TODO: 회원가입, 로그인, 로그아웃 구현

    @PostMapping("/auth/signup")
    public Long signup(@RequestBody UserRequestDto userRequestDto) throws DuplicatedEmailException {

        // 중복되는 회원 체크
        userService.findByEmailCheckDuplicated(userRequestDto.getEmail());

        // 기존에 회원이 없다면 회원 가입 진행
        User savedUser = userService.save(new User(userRequestDto));
        return savedUser.getId();
    }


//    @PostMapping("/auth/login")
//    public String login()
//    {
//
//    }
//
//    @GetMapping("/auth/logout")
//    public String logout()
//    {
//
//    }
}
