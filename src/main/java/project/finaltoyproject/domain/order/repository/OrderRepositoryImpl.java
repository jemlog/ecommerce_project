package project.finaltoyproject.domain.order.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.OrderState;
import project.finaltoyproject.domain.order.dto.OrderSearch;

import javax.persistence.EntityManager;
import java.util.List;

import static project.finaltoyproject.domain.order.QOrder.order;

public class OrderRepositoryImpl implements CustomOrderRepository{

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Page<Order> searchPage(Pageable pageable, OrderSearch orderSearch) {
        QueryResults<Order> orderQueryResults = queryFactory.select(order)
                .from(order)
                .where(orderStateEq(orderSearch.getOrderState()),
                        totalPriceGoe(orderSearch.getTotalPriceGoe()),
                        totalPriceLoe(orderSearch.getTotalPriceLoe()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Order> results = orderQueryResults.getResults();
        long total = orderQueryResults.getTotal();
        return new PageImpl<>(results,pageable,total);
    }

    private BooleanExpression totalPriceLoe(Integer totalPriceLoe) {
        return totalPriceLoe == null ? null : order.totalOrderPrice.loe(totalPriceLoe);
    }

    private BooleanExpression totalPriceGoe(Integer totalPriceGoe) {
        return totalPriceGoe == null ? null : order.totalOrderPrice.goe(totalPriceGoe);
    }

    private BooleanExpression orderStateEq(OrderState orderState) {
        return orderState == null ? null : order.orderState.eq(orderState);
    }

}