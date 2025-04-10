package system.scheduling.model.service;

import org.springframework.stereotype.Service;
import system.scheduling.model.domain.Schedule;
import system.scheduling.model.repository.ScheduleRepository;
import system.scheduling.model.util.CrudService;

@Service
public class ScheduleService extends CrudService<Schedule, Long> {
    public ScheduleService(ScheduleRepository repository) {
        super(repository);
    }
}
