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
}
