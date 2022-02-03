package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.posts.repository.PostsRepository;

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
}
