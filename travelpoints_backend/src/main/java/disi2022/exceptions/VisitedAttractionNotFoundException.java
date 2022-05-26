package disi2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VisitedAttractionNotFoundException extends RuntimeException {
    public VisitedAttractionNotFoundException(Integer id) {
        super(String.format("Visited attraction with id '%d' does not exist.", id));
    }
}
