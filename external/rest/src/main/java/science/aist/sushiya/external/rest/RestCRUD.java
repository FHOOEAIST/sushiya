package science.aist.sushiya.external.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Generic CRUD Methods with rest annotations
 *
 * @author Oliver Krauss on 17.03.2015.
 */
public interface RestCRUD<ID, DTO> {
    /**
     * POST method for inserting a new item
     *
     * @param item to be added
     * @return OK if item was created successfully, location header with URL of new item
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> insert(@RequestBody DTO item);


    /**
     * PUT method for inserting a list of new items
     *
     * @param items list of items to be added
     * @return OK if item was created successfully
     */
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Void> batchUpdate(@RequestBody List<DTO> items);

    /**
     * PUT method for inserting an item with id, or updating existing item
     *
     * @param id   of item to be added or updated
     * @param item to be added or updated
     * @return OK if item was updated successfully, CREATED if item was created successfully
     */
    @PutMapping(value = "/{id}")
    ResponseEntity<Void> update(@PathVariable("id") ID id, @RequestBody DTO item);

    /**
     * PUT method for inserting an item with id, or updating existing item
     *
     * @param id of item to be deleted
     * @return OK if item was deleted successfully, NOT_FOUND if item does not exist
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") ID id);
}
