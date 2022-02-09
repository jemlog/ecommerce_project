package project.finaltoyproject.domain.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.finaltoyproject.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
