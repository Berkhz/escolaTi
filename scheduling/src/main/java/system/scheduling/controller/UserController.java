package system.scheduling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.scheduling.model.domain.User;
import system.scheduling.model.service.UserService;
import system.scheduling.model.util.CrudController;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<User, Long, UserService> {
    public UserController(UserService service) {
        super(service, User.class);
    }
}
