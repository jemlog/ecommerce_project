package project.finaltoyproject.domain.posts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import project.finaltoyproject.domain.posts.Posts;

public interface PostsRepository extends JpaRepository<Posts,Long>,CustomPostsRepository {


}
