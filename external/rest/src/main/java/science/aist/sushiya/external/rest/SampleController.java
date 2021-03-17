package science.aist.sushiya.external.rest;

import science.aist.sushiya.core.dto.SampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Sample Rest Controller</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@RequestMapping(ControllerConstant.SAMPLE_ENDPOINT)
public interface SampleController {
    /**
     * POST method for inserting a new item
     *
     * @param item to be added
     * @return OK if item was created successfully, location header with URL of new item
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> insert(@RequestBody @Valid SampleDTO item);

    /**
     * @param id of item to be retrieved
     * @return Item that was requested or NOT_FOUND
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    SampleDTO read(@PathVariable("id") Long id);
}
