package system.scheduling.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import system.scheduling.model.domain.Appointment;
import system.scheduling.model.domain.Job;
import system.scheduling.model.repository.AppointmentRepository;
import system.scheduling.model.repository.ProviderRepository;
import system.scheduling.model.repository.UserRepository;
import system.scheduling.model.util.CrudService;

import java.util.List;

@Service
public class AppointmentService extends CrudService<Appointment, Long> {

    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository repository,
                              UserRepository userRepository,
                              ProviderRepository providerRepository,
                              AppointmentRepository appointmentRepository) {
        super(repository);
        this.userRepository = userRepository;
        this.providerRepository = providerRepository;
        this.appointmentRepository = appointmentRepository;

    }

    @Override
    public void beforeSave(Appointment entity) {

        validateAppointment(entity);

        entity.setUser(findEntity(userRepository,
                entity.getUser().getId()));
        entity.setProvider(findEntity(providerRepository,
                entity.getProvider().getId()));

    }

    private void validateAppointment(Appointment entity) {

        validateJob(entity);
        validateTime(entity);

    }

    private void validateTime(Appointment entity) {
        List<Appointment> appointments = getAppointmentsForProvider(entity);

        if (hasTimeConflict(entity, appointments)) {
            throw new RuntimeException("There is a appointment at the same time");
        }
    }

    private List<Appointment> getAppointmentsForProvider(Appointment entity) {

        return appointmentRepository.findAllByProviderId(entity.getProvider().getId());

    }

    private boolean hasTimeConflict(Appointment entity, List<Appointment> appointments) {
        return appointments.stream().anyMatch(existing -> isOverlapping(entity, existing));
    }

    private boolean isOverlapping(Appointment newAppointment, Appointment existingAppointment) {

        return newAppointment.getStartTime().isBefore(existingAppointment.getEndTime()) &&
                newAppointment.getEndTime().isAfter(existingAppointment.getStartTime());

    }


    private static void validateJob(Appointment entity) {

        List<Job> jobs = entity.getProvider().getJobs();
        if (jobs.stream().noneMatch(job -> job.getId().equals(entity.getJob().getId()))) {
            throw new RuntimeException("Job not found for provider");
        }

    }

    private <T> T findEntity(JpaRepository<T, Long> repository,
                             Long id) {

        return repository.findById(id).orElseThrow();

    }

    public List<Appointment> findAllByProviderId(Long providerId) {

        return appointmentRepository.findAllByProviderId(providerId);

    }

    public List<Appointment> findAllByUserId(Long userId) {

        return appointmentRepository.findAllByUserId(userId);

    }
}
