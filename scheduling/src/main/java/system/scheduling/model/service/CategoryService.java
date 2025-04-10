package system.scheduling.model.service;

import org.springframework.stereotype.Service;
import system.scheduling.model.domain.Category;
import system.scheduling.model.domain.Job;
import system.scheduling.model.repository.CategoryRepository;
import system.scheduling.model.repository.JobRepository;
import system.scheduling.model.util.CrudService;

@Service
public class CategoryService extends CrudService<Category, Long> {
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
