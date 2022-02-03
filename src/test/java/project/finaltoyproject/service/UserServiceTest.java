package project.finaltoyproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.domain.user.repository.UserRepository;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    @BeforeEach
    public void init()
    {
        UserRequestDto userRequestDto = new UserRequestDto("seojemin",
                "jemjem",
                "jemin03120111@gmail.com",
                "12345");
        User user = new User(userRequestDto);
        userRepository.save(user);
    }

    @Test
    void 중복된_회원이_있으면_예외발생() throws Exception
    {
        //given
        UserRequestDto userRequestDto = new UserRequestDto("user2",
                "useruser",
                "jemin03120111@gmail.com",
                "765432");

        // then
        Assertions.assertThrows(DuplicatedEmailException.class,
                () -> userService.findByEmailCheckDuplicated(userRequestDto.getEmail()) );
    }

}