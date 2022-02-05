package project.finaltoyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.posts.repository.PostsRepository;
import project.finaltoyproject.domain.user.User;
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
    public void delete(Long id) throws UserNotExistException {
        Optional<Posts> findPosts = postsRepository.findById(id);
        if(findPosts.isEmpty())
        {
            throw new UserNotExistException("존재하지 않는 게시글입니다.");
        }
        postsRepository.delete(findPosts.get());
    }

    public void hello()
    {
        Optional<String> str = Optional.of("hello");

        //orElse("default") -> orElse는 값이 존재한다면 .get()을 실행하고 아니면 Else절 내부를 실행한다.
        // 주의할 점은 Else 내부의 값 생성은 무조건 먼저 일어남으로, Else 내부에 새로운 객체 생성을 사용하면 안된다.
        // str.orElseGet(User::new);
        // 이런 식으로 orElseGet을 사용해야 즉시 생성이 안된다.
        str.orElseThrow(()-> new IllegalArgumentException()); // 예외 발생은 orElseThrow로 처리해준다.
        // 굳이 null 값일때를 처리하기위해 optional을 만들지 말고 그냥 3항 연산자로 계산하자.
        // 컬렉션 null로 처리할때는 optional 사용하지 말고 Collections.emptyList로 3항 연산자 처리해주자.
        // 메서드 내부에서는 그냥 null 체크를 반드시 해주자
        // 핵심 -> 기존 값을 null 체크 하기 위해서는 따로 optional 만들기 금지
        // spring data jpa에서는 컬렉션 반환할때 알아서 null 대신 emptyLst반환 그러므로 따로 메서드 선언시 optional로 반환
        // 하지 말자.
        // Optional.of는 절대 null값이 안 들어올때 사용! 널 나오면 널포인트exception 발생
        // Opptional.ofNullable 사용
        // 만약 숫자타입 Optional 적용시에는 오토박싱 막기 위해서 OptionalInt , Optional
    }
}
