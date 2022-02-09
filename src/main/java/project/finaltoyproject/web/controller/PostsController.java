package project.finaltoyproject.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.posts.dto.PostsRequestDto;
import project.finaltoyproject.domain.posts.dto.PostsResponseDto;
import project.finaltoyproject.domain.user.User;
import project.finaltoyproject.domain.user.dto.LoginDto;
import project.finaltoyproject.service.PostsService;
import project.finaltoyproject.service.UserService;
import project.finaltoyproject.util.exeption.ClientInvalidInputException;
import project.finaltoyproject.util.exeption.SessionRemoveException;
import project.finaltoyproject.util.exeption.UserNotExistException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postService;

    private final UserService userService;
    @GetMapping
    public Page<PostsResponseDto> findAll(@PageableDefault(size = 20) Pageable pageable)
    {
            Page<Posts> posts = postService.findAll(pageable);
            return posts.map(p -> new PostsResponseDto(p.getTitle(), p.getDescription(),p.getUser().getId()));

    }

    @PostMapping
    public String savePosts(@Login User loginUser, @RequestBody PostsRequestDto postsRequestDto) throws SessionRemoveException {
        User user = userService.findById(loginUser.getId());
        if(user == null)
        {
            throw new SessionRemoveException("인증되지 않은 사용자입니다.");
        }

        Posts newPosts = Posts.builder().title(postsRequestDto.getTitle())
                .description(postsRequestDto.getDescription())
                .build();

        newPosts.setUser(user);

        Posts savePosts = postService.save(newPosts);

        return savePosts.getTitle();
    }

    @DeleteMapping("/{id}")
    public String deletePosts(@PathVariable("id") Long id) throws ClientInvalidInputException {
        postService.delete(id);
        return "delete!";
    }
}
