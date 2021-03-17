package science.aist.sushiya.service.core;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Default functionality all services have
 *
 * @author Oliver Krauss on 03.03.2015.
 */
public interface Service<T, K> {

    /**
     * @param item saves or updates the given object
     * @return item with added id if it was created
     */
    @Modifying
    @Transactional
    T save(T item);

    /**
     * @param key of object to be found
     * @return object with corresponding key or null
     */
    @Transactional
    Optional<T> find(K key);

    /**
     * @return all items handled by service
     */
    @Transactional
    Collection<T> findAll();

    /**
     * removes item and all depending items from service
     *
     * @param item to be deleted
     */
    @Modifying
    @Transactional
    void delete(T item);
}
