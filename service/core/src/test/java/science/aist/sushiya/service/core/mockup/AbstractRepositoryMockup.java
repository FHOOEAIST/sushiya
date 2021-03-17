package science.aist.sushiya.service.core.mockup;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * <p>Created by Anna Reichhardt on 23.07.2019</p>
 *
 * @author Anna Reichhardt anna.reichhardt@fh-hagenberg.at
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 * @author Christoph Praschl christoph.praschl@fh-hagenberg.at
 */
public abstract class AbstractRepositoryMockup<T> implements JpaRepository<T, Long> {
    private Map<Long, T> map = new HashMap<>();
    private Long cnt = 0L;

    @Override
    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public List<T> findAllById(Iterable<Long> Ks) {
        return StreamSupport
                .stream(Ks.spliterator(), false)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return map.size();
    }

    @Override
    public void deleteById(Long aK) {
        map.remove(aK);
    }

    @Override
    public void delete(T entity) {
        findIdByType(entity).ifPresent(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        map.clear();
    }

    @Override
    public <S extends T> S save(S entity) {
        Long currentId = getId(entity);
        map.put(currentId, entity);
        return entity;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<T> findById(Long aK) {
        return Optional.ofNullable(map.get(aK));
    }

    @Override
    public boolean existsById(Long aK) {
        return findById(aK).isPresent();
    }

    @Override
    public void flush() {
        // guess nothing to do
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        try {
            return save(entity);
        } finally {
            flush();
        }
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        // who needs batch anyway :D
        deleteAll(entities);
    }

    @Override
    public void deleteAllInBatch() {
        // who needs batch anyway :D
        deleteAll();
    }

    @Override
    public T getOne(Long aK) {
        return findById(aK).orElse(null);
    }

    @Override
    public List<T> findAll(Sort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    private Optional<Long> findIdByType(T entity) {
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(entity))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    private Long getId(T elem) {
        Field fieldWithIdAnnotation = null;
        Field fieldWithIdName = null;

        outerfor:
        for (Field declaredField : elem.getClass().getDeclaredFields()) {
            for (Annotation annotation : declaredField.getAnnotations()) {
                if (annotation.getClass().getSimpleName().equals("Id")) {
                    fieldWithIdAnnotation = declaredField;
                    break outerfor;
                }
            }
            if (declaredField.getName().equals("id")) {
                fieldWithIdName = declaredField;
            }
        }

        if (fieldWithIdAnnotation == null && fieldWithIdName == null) {
            throw new IllegalArgumentException("Given Object has no id field");
        }

        Field idField = fieldWithIdAnnotation != null ? fieldWithIdAnnotation : fieldWithIdName;

        if (!idField.getType().equals(Long.class) && !idField.getType().equals(long.class)) {
            throw new IllegalArgumentException("Given Object has a not long/Long id field");
        }

        Long result = -1L;

        boolean isAccessible = idField.canAccess(elem);
        idField.setAccessible(true);
        try {
            Long id = (Long) idField.get(elem);
            if (id == null) {
                result = cnt++;
                idField.set(elem, result);
            } else {
                result = id;
            }
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access id field");
        } finally {
            idField.setAccessible(isAccessible);
        }

        return result;
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException();
    }
}