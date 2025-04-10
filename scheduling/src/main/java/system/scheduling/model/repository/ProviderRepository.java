package system.scheduling.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.scheduling.model.domain.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
