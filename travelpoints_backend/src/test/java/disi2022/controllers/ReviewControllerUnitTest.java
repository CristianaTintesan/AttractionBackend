//package disi2022.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import disi2022.Disi2022TestConfig;
//import disi2022.dtos.AttractionDTO;
//import disi2022.dtos.ReviewDTO;
//import disi2022.dtos.UserDTO;
//import disi2022.dtos.VisitedAttractionDTO;
//import disi2022.entities.Attraction;
//import disi2022.entities.Review;
//import disi2022.entities.User;
//import disi2022.entities.VisitedAttraction;
//import disi2022.enums.UserRole;
//import disi2022.exceptions.ReviewNotFoundException;
//import disi2022.exceptions.VisitedAttractionNotFoundException;
//import disi2022.services.ReviewService;
//import disi2022.services.VisitedAttractionService;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.sql.Timestamp;
//
//import static disi2022.enums.UserRole.TOURIST;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class ReviewControllerUnitTest extends Disi2022TestConfig {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ReviewService reviewService;
//
//    @Test
//    public void insertReviewTest() throws Exception {
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
//        ReviewDTO reviewDTO = new ReviewDTO(5, "stopWAR", userDTO, attractionDTO);
//        Review review = new Review();
//        review.setId(5);
//        review.setMessage("stopWAR!");
//        review.setAttraction(attraction);
//        review.setUser(user);
//        Mockito.when(reviewService.add(Mockito.any(Review.class))).thenReturn(review);
//
//        mockMvc.perform(post("/review")
//                .content(objectMapper.writeValueAsString(reviewDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void findReviewTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        User user = new User();
//        user.setId(7);
//        user.setRole(TOURIST);
//
//        Review review = new Review();
//        review.setId(5);
//        review.setMessage("test");
//        review.setAttraction(attraction);
//        review.setUser(user);
//
//        Mockito.when(reviewService.getOne(5)).thenReturn(review);
//
//        mockMvc.perform(get("/review/5")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findReviewTestFailsDueToNonexistent() throws Exception {
//        Mockito.when(reviewService.getOne(100)).thenThrow(new ReviewNotFoundException(100));
//
//        mockMvc.perform(get("/review/100")
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void updateReviewTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//        attraction.setName("nice");
//        attraction.setDescription("cluj");
//        attraction.setLocation("muzeu");
//        attraction.setPrice(45);
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
//        ReviewDTO reviewDTO = new ReviewDTO(5, "stopWAR", userDTO, attractionDTO);
//        Review review = new Review();
//        review.setId(5);
//        review.setMessage("stopWAR!");
//        review.setAttraction(attraction);
//        review.setUser(user);
//
//        Mockito.when(reviewService.update(Mockito.any(Review.class))).thenReturn(review);
//
//        mockMvc.perform(put("/review/5")
//                .content(objectMapper.writeValueAsString(reviewDTO))
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    public void updateReviewTestFailsDueToNonexistent() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//        UserDTO userDTO = new UserDTO(7,"Ionel", "Zelensky", "GhostOfKiev", "parolacriptata", 1);
//        ReviewDTO reviewDTO = new ReviewDTO(5, "stopWAR", userDTO, attractionDTO);
//
//        Mockito.when(reviewService.update(Mockito.any(Review.class))).thenThrow(new ReviewNotFoundException(10));
//
//        mockMvc.perform(put("/review/100")
//                .content(objectMapper.writeValueAsString(reviewDTO))
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    public void deleteReviewTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        User user = new User();
//        user.setId(7);
//        user.setRole(TOURIST);
//
//        Review review = new Review();
//        review.setId(5);
//        review.setMessage("stopWAR!");
//        review.setAttraction(attraction);
//        review.setUser(user);
//
//        mockMvc.perform(delete("/review/5")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//}
