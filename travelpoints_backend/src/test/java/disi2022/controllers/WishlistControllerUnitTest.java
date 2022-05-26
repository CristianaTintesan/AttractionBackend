//package disi2022.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import disi2022.Disi2022TestConfig;
//import disi2022.dtos.AttractionDTO;
//import disi2022.dtos.ReviewDTO;
//import disi2022.dtos.UserDTO;
//import disi2022.dtos.WishlistDTO;
//import disi2022.entities.Attraction;
//import disi2022.entities.Review;
//import disi2022.entities.User;
//import disi2022.entities.Wishlist;
//import disi2022.exceptions.ReviewNotFoundException;
//import disi2022.exceptions.WishlistNotFoundException;
//import disi2022.services.VisitedAttractionService;
//import disi2022.services.WishlistService;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static disi2022.enums.UserRole.TOURIST;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class WishlistControllerUnitTest extends Disi2022TestConfig {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private WishlistService wishlistService;
//
//    @Test
//    public void insertWishlistTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        UserDTO userDTO = new UserDTO(7,"Ionel", "Zelensky", "GhostOfKiev", "parolacriptata", 1);
//        User user = new User();
//        user.setId(7);
//        user.setFirstName("Ionel");
//        user.setLastName("Zelensky");
//        user.setUsername("GhostOfKiev");
//        user.setPassword("parolacriptata");
//        user.setRole(TOURIST);
//
//        WishlistDTO wishlistDTO = new WishlistDTO(5, userDTO, attractionDTO);
//        Wishlist wishlist = new Wishlist();
//        wishlist.setId(7);
//        wishlist.setUser(user);
//        wishlist.setAttraction(attraction);
//
//        Mockito.when(wishlistService.add(Mockito.any(Wishlist.class))).thenReturn(wishlist);
//
//        mockMvc.perform(post("/wishlist")
//                .content(objectMapper.writeValueAsString(wishlistDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void findWishlistTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        User user = new User();
//        user.setId(7);
//        user.setRole(TOURIST);
//
//        Wishlist wishlist = new Wishlist();
//        wishlist.setId(5);
//        wishlist.setUser(user);
//        wishlist.setAttraction(attraction);
//
//        Mockito.when(wishlistService.getOne(5)).thenReturn(wishlist);
//
//        mockMvc.perform(get("/wishlist/5")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findWishlistTestFailsDueToNonexistent() throws Exception {
//        Mockito.when(wishlistService.getOne(100)).thenThrow(new WishlistNotFoundException(100));
//
//        mockMvc.perform(get("/wishlist/100")
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//    }
//
//}
