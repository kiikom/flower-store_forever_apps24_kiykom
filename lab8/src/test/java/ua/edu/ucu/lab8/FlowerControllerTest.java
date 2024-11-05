package ua.edu.ucu.lab8;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.edu.ucu.lab8.model.Flower;
import ua.edu.ucu.lab8.service.FlowerService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlowerController.class)
public class FlowerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlowerService flowerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Flower flower1;
    private Flower flower2;

    @BeforeEach
    public void setUp() {
        flower1 = new Flower();
        flower1.setId(1);
        flower1.setFlower("Rose");
        flower1.setPrice(10.5);
        flower1.setColor("Red");
        flower1.setAvailable(true);

        flower2 = new Flower();
        flower2.setId(2);
        flower2.setFlower("Tulip");
        flower2.setPrice(8.5);
        flower2.setColor("Yellow");
        flower2.setAvailable(true);
    }

    @Test
    public void testGetFlowers() throws Exception {
        List<Flower> flowers = Arrays.asList(flower1, flower2);

        when(flowerService.getFlowers()).thenReturn(flowers);

        mockMvc.perform(get("/api/v1/flower"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(flowers)));
    }

    @Test
    public void testCreateFlower() throws Exception {
        Flower newFlower = new Flower();
        newFlower.setFlower("Lily");
        newFlower.setPrice(12.5);
        newFlower.setColor("White");
        newFlower.setAvailable(true);

        when(flowerService.createFlower(Mockito.any(Flower.class))).thenReturn(newFlower);

        mockMvc.perform(post("/api/v1/flower")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newFlower)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(newFlower)));
    }
}