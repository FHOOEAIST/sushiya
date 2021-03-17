package science.aist.sushiya.external.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Generic Query Methods with REST annotations
 * @author Oliver Krauss on 17.03.2015.
 */
public interface  RestQueries <ID, DTO> {
    /**
     * @param id of item to be retrieved
     * @return Item that was requested or NOT_FOUND
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    DTO read(@PathVariable("id") ID id);

    /**
     * @return all items that are in the system
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Collection<DTO> read();
}
