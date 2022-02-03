package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.repository.UserRepository;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;
import project.finaltoyproject.util.exeption.UserNotExistException;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user)
    {
        return userRepository.save(user);
    }

    public void findByEmailCheckDuplicated(String email) throws DuplicatedEmailException {

        Optional<User> findUser = userRepository.findByEmail(email);
        if(!findUser.isEmpty())
        {
            throw new DuplicatedEmailException("중복된 회원입니다.");
        }
    }

    public User findByEmailForLogin(String email,String password) {
        return userRepository.findByEmail(email).filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }
}
