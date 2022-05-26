package disi2022.services;

import disi2022.converter.WishlistConverter;
import disi2022.dtos.WishlistDTO;
import disi2022.entities.Wishlist;
import disi2022.exceptions.UserNotFoundException;
import disi2022.repositories.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public List<WishlistDTO> getAll() {
        return wishlistRepository.findAll().stream()
                .map(WishlistConverter::wishlistDTO)
                .collect(Collectors.toList());
    }

    public Wishlist getOne(int id) {
        return wishlistRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Wishlist add(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void delete(int id) {
        wishlistRepository.deleteById(id);
    }
    public void deleteByAttractionAndId(int attractionId, int userId){
        wishlistRepository.deleteWishlistByAttractionAndUser(attractionId, userId);
    }
}
