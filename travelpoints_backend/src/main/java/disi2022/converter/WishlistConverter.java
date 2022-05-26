package disi2022.converter;

import disi2022.dtos.WishlistDTO;
import disi2022.entities.Wishlist;

public class WishlistConverter {
    public static WishlistDTO wishlistDTO(Wishlist wishlist) {
        return WishlistDTO.builder()
                .id(wishlist.getId())
                .user(UserConverter.userToDto(wishlist.getUser()))
                .attraction(AttractionConverter.attractionToDto(wishlist.getAttraction()))
                .build();
    }

    public static Wishlist dtoToWishlist(WishlistDTO dto) {
        return Wishlist.builder()
                .id(dto.getId())
                .user(UserConverter.dtoToUser(dto.getUser()))
                .attraction(AttractionConverter.dtoToAttraction(dto.getAttraction()))
                .build();
    }
}
