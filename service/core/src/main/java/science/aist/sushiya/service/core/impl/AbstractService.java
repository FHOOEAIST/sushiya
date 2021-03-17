package science.aist.sushiya.service.core.impl;

import science.aist.sushiya.service.core.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;


/**
 * <p>Created by Anna Reichhardt on 27.08.2019</p>
 *
 * @author Anna Reichhardt anna.reichhardt@fh-hagenberg.at
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@AllArgsConstructor
public abstract class AbstractService<T, K, R extends JpaRepository<T, K>> implements Service<T, K> {
    protected R repository;

    @Override
    public T save(T item) {
        return repository.save(item);
    }

    @Override
    public Optional<T> find(K key) {
        return repository.findById(key);
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(T item) {
        repository.delete(item);
    }
}