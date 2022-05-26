package disi2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WishlistNotFoundException extends RuntimeException {
    public WishlistNotFoundException(Integer id) {
        super(String.format("Wishlist with id '%d' does not exist.", id));
    }
}
