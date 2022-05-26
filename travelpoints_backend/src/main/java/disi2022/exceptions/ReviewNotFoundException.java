package disi2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(Integer id) {
        super(String.format("Review with id '%d' does not exist.", id));
    }
}
