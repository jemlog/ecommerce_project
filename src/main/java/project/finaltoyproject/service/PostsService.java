package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.posts.repository.PostsRepository;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.util.exeption.ClientInvalidInputException;
import project.finaltoyproject.util.exeption.UserNotExistException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostsService {

    private final PostsRepository postsRepository;

    public Page<Posts> findAll(Pageable pageable)
    {
        return postsRepository.findAll(pageable);
    }

    @Transactional
    public Posts save(Posts posts)
    {
        return postsRepository.save(posts);
    }

    @Transactional
    public void delete(Long id) throws ClientInvalidInputException {

        Optional<Posts> findPosts = postsRepository.findById(id);
        Posts posts = findPosts.orElseThrow(() -> new ClientInvalidInputException("사용자가 잘못된 값을 입력했습니다."));
        postsRepository.delete(posts);
    }

}
