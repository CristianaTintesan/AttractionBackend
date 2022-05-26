//package disi2022.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import disi2022.Disi2022TestConfig;
//import disi2022.dtos.AttractionDTO;
//import disi2022.dtos.UserDTO;
//import disi2022.entities.Attraction;
//import disi2022.entities.User;
//import disi2022.exceptions.AttractionNotFoundException;
//import disi2022.exceptions.UserNotFoundException;
//import disi2022.services.AttractionService;
//import disi2022.services.UserService;
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
//public class UserControllerUnitTest extends Disi2022TestConfig {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void insertUserTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
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
//        Mockito.when(userService.add(Mockito.any(User.class))).thenReturn(user);
//
//        mockMvc.perform(post("/user")
//                .content(objectMapper.writeValueAsString(userDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void findUserTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        User user = new User();
//        user.setId(7);
//        user.setRole(TOURIST);
//
//        Mockito.when(userService.getOne(7)).thenReturn(user);
//
//        mockMvc.perform(get("/user/7")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findUserTestFailsDueToNonexistent() throws Exception {
//        Mockito.when(userService.getOne(100)).thenThrow(new UserNotFoundException(100));
//
//        mockMvc.perform(get("/user/100")
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void updateUserTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        UserDTO userDTO = new UserDTO(7,"Ionel", "Zelensky", "GhostOfKiev", "parolacriptata", 1);
//        User user = new User();
//        user.setId(123);
//        user.setFirstName("Ionel");
//        user.setLastName("Zelensky");
//        user.setUsername("GhostOfKiev");
//        user.setPassword("parolacriptata");
//        user.setRole(TOURIST);
//
//
//        Mockito.when(userService.update(Mockito.any(User.class))).thenReturn(user);
//
//        mockMvc.perform(put("/user/2")
//                .content(objectMapper.writeValueAsString(userDTO))
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    public void updateUserTestFailsDueToNonexistent() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        UserDTO userDTO = new UserDTO(7,"Ionel", "Zelensky", "GhostOfKiev", "parolacriptata", 1);
//
//        User user = new User();
//        user.setId(100);
//        user.setFirstName("Ionel");
//        user.setLastName("Zelensky");
//        user.setUsername("GhostOfKiev");
//        user.setPassword("parolacriptata");
//        user.setRole(TOURIST);
//
//        Mockito.when(userService.update(Mockito.any(User.class))).thenThrow(new UserNotFoundException(100));
//
//        mockMvc.perform(put("/user/100")
//                .content(objectMapper.writeValueAsString(userDTO))
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    public void deleteUserTest() throws Exception {
//        User user = new User();
//        user.setId(123);
//        user.setRole(TOURIST);
//
//        mockMvc.perform(delete("/user/123")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//}
