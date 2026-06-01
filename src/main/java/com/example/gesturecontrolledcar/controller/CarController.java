package com.example.gesturecontrolledcar.controller;

import com.example.gesturecontrolledcar.model.CarStatus;
import com.example.gesturecontrolledcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping("/status")
    public String receiveDataFromESP32(@RequestBody CarStatus status) {
        service.saveStatus(status);
        return "Backend Java đã nhận và lưu dữ liệu thành công!";
    }

    @GetMapping("/status")
    public CarStatus sendDataToWeb() {
        return service.getLatestStatus();
    }
}