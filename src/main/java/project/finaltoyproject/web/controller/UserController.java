package project.finaltoyproject.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.ProfileResponseDto;
import project.finaltoyproject.domain.user.dto.UserDto;
import project.finaltoyproject.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원가입",description = "이름,닉네임,비밀번호로 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<User> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        System.out.println("singup 호출!");
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        System.out.println("hello~~~~");
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/profile/{id}")
    public ProfileResponseDto getProfile(@PathVariable("id") Long userId)
    {
        User findUser = userService.findById(userId);
        return new ProfileResponseDto(findUser);
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
}