package project.finaltoyproject.domain.user.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.OrderState;
import project.finaltoyproject.domain.order.dto.OrderSearch;
import project.finaltoyproject.domain.user.QUser;
import project.finaltoyproject.domain.user.User;

import javax.persistence.EntityManager;
import java.util.List;

import static project.finaltoyproject.domain.order.QOrder.order;
import static project.finaltoyproject.domain.user.QUser.user;

public class UserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }



}
