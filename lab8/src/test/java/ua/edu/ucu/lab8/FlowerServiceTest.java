package ua.edu.ucu.lab8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.edu.ucu.lab8.model.Flower;
import ua.edu.ucu.lab8.repository.FlowerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FlowerServiceTest {

    @InjectMocks
    private FlowerService flowerService;

    @Mock
    private FlowerRepository flowerRepository;

    private Flower flower1;
    private Flower flower2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
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
    public void testGetFlowers() {
        List<Flower> flowers = Arrays.asList(flower1, flower2);
        
        when(flowerRepository.findAll()).thenReturn(flowers);

        List<Flower> result = flowerService.getFlowers();
        assertEquals(2, result.size());
        assertEquals("Rose", result.get(0).getFlower());
    }

    @Test
    public void testCreateFlower() {
        Flower newFlower = new Flower();
        newFlower.setFlower("Lily");
        newFlower.setPrice(12.5);
        newFlower.setColor("White");
        newFlower.setAvailable(true);

        when(flowerRepository.save(newFlower)).thenReturn(newFlower);

        Flower result = flowerService.createFlower(newFlower);
        assertEquals("Lily", result.getFlower());
        assertEquals(12.5, result.getPrice());
    }
}