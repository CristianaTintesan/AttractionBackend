package disi2022.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super(String.format("User with id '%d' does not exist.", id));
    }

    public UserNotFoundException(String username) {
        super(String.format("User with username '%s' does not exist.", username));
    }
}
