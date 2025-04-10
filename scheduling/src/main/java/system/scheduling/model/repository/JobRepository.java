package system.scheduling.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.scheduling.model.domain.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
