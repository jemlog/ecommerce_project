package project.finaltoyproject.domain.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.order.dto.OrderSearch;

public interface CustomOrderRepository {
    Page<Order> searchPage(Pageable pageable, OrderSearch orderSearch);
}
