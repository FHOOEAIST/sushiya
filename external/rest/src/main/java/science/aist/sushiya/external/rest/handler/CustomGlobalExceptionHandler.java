package science.aist.sushiya.external.rest.handler;

import at.fh.hagenberg.aist.jfuck.data.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Global Exception Handling</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        //Get all errors
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> Pair.of(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Pair.toMap());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }

}

