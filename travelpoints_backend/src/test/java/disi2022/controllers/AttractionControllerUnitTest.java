//package disi2022.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import disi2022.Disi2022TestConfig;
//import disi2022.dtos.AttractionDTO;
//import disi2022.dtos.VisitedAttractionDTO;
//import disi2022.entities.Attraction;
//import disi2022.entities.VisitedAttraction;
//import disi2022.exceptions.AttractionNotFoundException;
//import disi2022.exceptions.VisitedAttractionNotFoundException;
//import disi2022.services.AttractionService;
//import disi2022.services.VisitedAttractionService;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.sql.Timestamp;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class AttractionControllerUnitTest extends Disi2022TestConfig {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AttractionService attractionService;
//
//    @Test
//    public void insertAttractionTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        AttractionDTO attractionDTO = new AttractionDTO (2,null, null, null, 0, null );
//
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        Mockito.when(attractionService.add(Mockito.any(Attraction.class))).thenReturn(attraction);
//
//        mockMvc.perform(post("/attraction")
//                .content(objectMapper.writeValueAsString(attractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void findAttractionTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        Mockito.when(attractionService.getOne(2)).thenReturn(attraction);
//
//        mockMvc.perform(get("/attraction/2")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findAttractionTestFailsDueToNonexistent() throws Exception {
//        Mockito.when(attractionService.getOne(100)).thenThrow(new AttractionNotFoundException(100));
//
//        mockMvc.perform(get("/attraction/100")
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void updateAttractionTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//        attraction.setName("nice");
//        attraction.setDescription("cluj");
//        attraction.setLocation("muzeu");
//        attraction.setPrice(45);
//
//
//        Mockito.when(attractionService.update(Mockito.any(Attraction.class))).thenReturn(attraction);
//
//        mockMvc.perform(put("/attraction/2")
//                .content(objectMapper.writeValueAsString(attractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//
//    }
//
//
//    @Test
//    public void updateAttractionTestFailsDueToNonexistent() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(100, "nice", "cluj", "muzeu", 45, null );
//
//        Mockito.when(attractionService.update(Mockito.any(Attraction.class))).thenThrow(new AttractionNotFoundException(100));
//
//        mockMvc.perform(put("/attraction/100")
//                .content(objectMapper.writeValueAsString(attractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    public void deleteAttractionTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        mockMvc.perform(delete("/attraction/2")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//
//}
