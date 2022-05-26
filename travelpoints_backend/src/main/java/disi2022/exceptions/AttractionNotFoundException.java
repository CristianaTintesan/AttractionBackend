package disi2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AttractionNotFoundException extends RuntimeException{
    public AttractionNotFoundException(Integer id) {
        super(String.format("Attraction with id '%d' does not exist.", id));
    }

}
