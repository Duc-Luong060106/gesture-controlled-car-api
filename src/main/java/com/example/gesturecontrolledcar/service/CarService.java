package com.example.gesturecontrolledcar.service;

import com.example.gesturecontrolledcar.model.CarStatus;
import com.example.gesturecontrolledcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public void saveStatus(CarStatus status) {
        repository.save(status);
    }

    public CarStatus getLatestStatus() {
        return repository.findTopByOrderByIdDesc().orElseGet(() -> {
            CarStatus defaultStatus = new CarStatus();
            defaultStatus.setDistance(0);
            defaultStatus.setSpeed(0);
            defaultStatus.setDirection("Dừng");
            defaultStatus.setIsSOS(false);
            return defaultStatus;
        });
    }
}