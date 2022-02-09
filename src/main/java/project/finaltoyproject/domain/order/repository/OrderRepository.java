package project.finaltoyproject.domain.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.posts.repository.CustomPostsRepository;

public interface OrderRepository extends JpaRepository<Order,Long> , CustomOrderRepository {
}
