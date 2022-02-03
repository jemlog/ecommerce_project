package project.finaltoyproject.domain.posts.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class PostsRepositoryImpl implements CustomPostsRepository{

    private final JPAQueryFactory queryFactory;

    public PostsRepositoryImpl(EntityManager em)
    {
        this.queryFactory = new JPAQueryFactory(em);
    }


}
