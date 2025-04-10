package system.scheduling.controller;

import org.springframework.web.bind.annotation.*;
import system.scheduling.model.domain.Job;
import system.scheduling.model.domain.Provider;
import system.scheduling.model.service.ProviderService;
import system.scheduling.model.util.CrudController;

@RestController
@RequestMapping("/providers")
public class ProviderController extends CrudController<Provider, Long, ProviderService> {

    public ProviderController(ProviderService service) {
        super(service, Provider.class);
    }

    @PostMapping("/{providerId}/jobs")
    public Provider addJobToProvider(@PathVariable Long providerId, @RequestBody Job job) {
        return service.addJobToProvider(providerId, job);
    }

}
