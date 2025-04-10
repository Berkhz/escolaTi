package system.scheduling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.scheduling.model.domain.Appointment;
import system.scheduling.model.service.AppointmentService;
import system.scheduling.model.util.CrudController;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController extends CrudController<Appointment, Long, AppointmentService> {
    public AppointmentController(AppointmentService service) {
        super(service, Appointment.class);
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<Appointment>> getByProviderId(@PathVariable Long providerId) {
        return ResponseEntity.ok(service.findAllByProviderId(providerId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Appointment>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }
}
