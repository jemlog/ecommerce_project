package project.finaltoyproject.domain.posts.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.OrderState;
import project.finaltoyproject.domain.order.QOrder;
import project.finaltoyproject.domain.order.dto.OrderSearch;

import javax.persistence.EntityManager;

import java.util.List;

import static project.finaltoyproject.domain.order.QOrder.order;

public class PostsRepositoryImpl implements CustomPostsRepository{

    private final JPAQueryFactory queryFactory;

    public PostsRepositoryImpl(EntityManager em)
    {
        this.queryFactory = new JPAQueryFactory(em);
    }



}
