package ua.edu.ucu.lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.edu.ucu.lab8.model.Flower;
@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer>{
    
}
