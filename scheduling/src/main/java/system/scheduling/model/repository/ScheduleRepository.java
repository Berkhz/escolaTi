package system.scheduling.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.scheduling.model.domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
