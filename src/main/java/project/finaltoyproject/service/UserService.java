package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.authority.Authority;
import project.finaltoyproject.domain.user.Grade;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.UserDto;
import project.finaltoyproject.domain.user.repository.UserRepository;
import project.finaltoyproject.util.SecurityUtil;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;


import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public User save(User user)
    {
        return userRepository.save(user);
    }

    public void findByEmailCheckDuplicated(String email) throws DuplicatedEmailException {

        Optional<User> findByEmail = userRepository.findByEmail(email);
        if(findByEmail.isPresent())
        {
            throw new DuplicatedEmailException("이미 존재하는 회원입니다.");
        }


    }

    public User findByEmail(String email,String password) {

        return userRepository.findByEmail(email).filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByUsername(String username,String password)
    {
        User user = userRepository.findUserByUsername(username)
                .get(0);
        //        .stream()
          //      .filter(u -> u.getPassword().equals(password))
            //    .findFirst().orElseThrow(() -> new IllegalStateException("해당되는 유저가 없다."));
        return user;
    }


    // ==============================================================





    @Transactional
    public User signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        /**
         * 권한 정보를 만든다. 기본적으로 회원가입을 하면 ROLE_USER라는 권한을 부여한다.
         */
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        System.out.println(authority.toString());


        // 유저 정보 + 권한 정보로 user 만듬
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .grade(Grade.BRONZE)
                .totalOrderPriceForCheckingGrade(0)
                .authorities(Collections.singleton(authority)) // Set 객체 하나만 저장하기 위함이다. user는 권한 role_user만 가져야함
                .activated(true)
                .build();
        System.out.println(user);
        // 저장
        System.out.println("저장!");
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}
