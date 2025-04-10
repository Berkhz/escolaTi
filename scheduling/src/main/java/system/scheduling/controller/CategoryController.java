package system.scheduling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.scheduling.model.domain.Category;
import system.scheduling.model.domain.User;
import system.scheduling.model.service.CategoryService;
import system.scheduling.model.service.UserService;
import system.scheduling.model.util.CrudController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Category, Long, CategoryService> {
    public CategoryController(CategoryService service) {
        super(service, Category.class);
    }
}
