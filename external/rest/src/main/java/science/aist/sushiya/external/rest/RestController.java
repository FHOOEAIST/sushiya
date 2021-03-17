package science.aist.sushiya.external.rest;

/**
 * Combined interface for CRUD and Query Methods
 *
 * @author Oliver Krauss on 17.03.2015.
 */
public interface RestController<ID, DTO> extends RestCRUD<ID, DTO>, RestQueries<ID, DTO> {
}
