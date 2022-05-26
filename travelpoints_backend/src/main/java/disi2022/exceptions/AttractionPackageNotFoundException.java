package disi2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AttractionPackageNotFoundException extends RuntimeException {
    public AttractionPackageNotFoundException(Integer id) {
        super(String.format("Attraction package with id '%d' does not exist.", id));
    }
}
