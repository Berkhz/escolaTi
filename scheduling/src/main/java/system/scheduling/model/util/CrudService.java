package system.scheduling.model.util;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;


public abstract class CrudService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public CrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        beforeSave(entity);
        return repository.save(entity);
    }

    public void beforeSave(T entity) {}

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T update(ID id, T entity) {
        return repository.findById(id)
                .map(existingEntity -> {
                    merge(existingEntity, entity);
                    return repository.save(existingEntity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada com ID: " + id));
    }


    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado");
        }
        repository.deleteById(id);
    }

    private void merge(T existingEntity, T newEntity) {
        Field[] fields = existingEntity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(newEntity);
                if (newValue != null) {
                    field.set(existingEntity, newValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao mesclar entidade", e);
            }
        }
    }
}
