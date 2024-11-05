package ua.edu.ucu.lab8.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class FlowerService {
    private FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }
    public List<Flower> getFlowers(){
        return flowerRepository.findAll();
    }
    public Flower createFlower(Flower flower){
        return flowerRepository.save(flower);
    }
}

