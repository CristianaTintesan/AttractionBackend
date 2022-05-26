package disi2022.controllers;

import disi2022.converter.WishlistConverter;
import disi2022.dtos.WishlistDTO;
import disi2022.entities.Wishlist;
import disi2022.services.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<Collection<WishlistDTO>> getWishlists() {
        List<WishlistDTO> dtos = wishlistService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistDTO> getWishlist(@PathVariable int id) {
        Wishlist wishlist = wishlistService.getOne(id);
        return new ResponseEntity<>(WishlistConverter.wishlistDTO(wishlist), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WishlistDTO> addWishlist(@RequestBody WishlistDTO dto) {
        Wishlist wishlist = wishlistService.add(WishlistConverter.dtoToWishlist(dto));
        return new ResponseEntity<>(WishlistConverter.wishlistDTO(wishlist), HttpStatus.CREATED);
    }

    @DeleteMapping("{attractionId}/{userId}")
    public ResponseEntity<Integer> deleteWishlist(@PathVariable int attractionId, @PathVariable int userId) {
        wishlistService.deleteByAttractionAndId(attractionId, userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }
}
