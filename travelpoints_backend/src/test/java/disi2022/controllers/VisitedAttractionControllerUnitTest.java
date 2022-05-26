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
//import disi2022.repositories.VisitedAttractionRepository;
//import disi2022.services.VisitedAttractionService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.Optional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class VisitedAttractionControllerUnitTest extends Disi2022TestConfig {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private VisitedAttractionService visitedAttractionService;
//
//    @Test
//    public void insertVisitedAttractionTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        AttractionDTO attractionDTO = new AttractionDTO (2,null, null, null, 0, null );
//        VisitedAttractionDTO visitedAttractionDTO = new VisitedAttractionDTO(10,Timestamp.valueOf("2018-09-01 09:01:15"), attractionDTO);
//
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        VisitedAttraction visitedAttraction = new VisitedAttraction();
//        visitedAttraction.setId(10);
//        visitedAttraction.setTimestamp(Timestamp.valueOf("2018-09-01 09:01:15"));
//        visitedAttraction.setAttraction(attraction);
//        Mockito.when(visitedAttractionService.add(Mockito.any(VisitedAttraction.class))).thenReturn(visitedAttraction);
//
//        mockMvc.perform(post("/visitedAttraction")
//                .content(objectMapper.writeValueAsString(visitedAttractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void findVisitedAttractionTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        VisitedAttraction visitedAttraction = new VisitedAttraction();
//        visitedAttraction.setId(10);
//        visitedAttraction.setTimestamp(Timestamp.valueOf("2018-09-01 09:01:15"));
//        visitedAttraction.setAttraction(attraction);
//        Mockito.when(visitedAttractionService.getOne(10)).thenReturn(visitedAttraction);
//
//        mockMvc.perform(get("/visitedAttraction/10")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findVisitedAttractionTestFailsDueToNonexistent() throws Exception {
//        Mockito.when(visitedAttractionService.getOne(100)).thenThrow(new VisitedAttractionNotFoundException(100));
//
//        mockMvc.perform(get("/visitedAttraction/100")
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void updateVisitedAttractionTest() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//        VisitedAttractionDTO visitedAttractionDTO = new VisitedAttractionDTO(10, Timestamp.valueOf("2018-09-01 09:01:15") , attractionDTO);
//
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//        attraction.setName("nice");
//        attraction.setDescription("cluj");
//        attraction.setLocation("muzeu");
//        attraction.setPrice(45);
//
//        VisitedAttraction visitedAttraction = new VisitedAttraction();
//        visitedAttraction.setId(5);
//        visitedAttraction.setTimestamp(Timestamp.valueOf("2018-09-01 09:01:15"));
//        visitedAttraction.setAttraction(attraction);
//
//        Mockito.when(visitedAttractionService.update(Mockito.any(VisitedAttraction.class))).thenReturn(visitedAttraction);
//
//        mockMvc.perform(put("/visitedAttraction/5")
//                .content(objectMapper.writeValueAsString(visitedAttractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    public void updateVisitedAttractionTestFailsDueToNonexistent() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        AttractionDTO attractionDTO = new AttractionDTO(2, "nice", "cluj", "muzeu", 45, null );
//        VisitedAttractionDTO visitedAttractionDTO = new VisitedAttractionDTO(5, Timestamp.valueOf("2018-09-01 09:01:15") , attractionDTO);
//
//        Mockito.when(visitedAttractionService.update(Mockito.any(VisitedAttraction.class))).thenThrow(new VisitedAttractionNotFoundException(10));
//
//        mockMvc.perform(put("/visitedAttraction/5")
//                .content(objectMapper.writeValueAsString(visitedAttractionDTO))
//                .contentType("application/json"))
//                .andExpect(status().isNotFound());
//
//    }
//
//    @Test
//    public void deleteVisitedAttractionTest() throws Exception {
//        Attraction attraction = new Attraction();
//        attraction.setId(2);
//
//        VisitedAttraction visitedAttraction = new VisitedAttraction();
//        visitedAttraction.setId(10);
//        visitedAttraction.setTimestamp(Timestamp.valueOf("2018-09-01 09:01:15"));
//        visitedAttraction.setAttraction(attraction);
//
//        mockMvc.perform(delete("/visitedAttraction/10")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//
//}
