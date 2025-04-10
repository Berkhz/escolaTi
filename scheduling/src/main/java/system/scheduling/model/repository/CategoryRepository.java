package system.scheduling.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.scheduling.model.domain.Category;
import system.scheduling.model.domain.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
