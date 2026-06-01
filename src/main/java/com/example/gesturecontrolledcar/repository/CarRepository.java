package com.example.gesturecontrolledcar.repository;

import com.example.gesturecontrolledcar.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarStatus, Long> {

    // Dùng để lấy bản ghi mới nhất hiển thị lên Dashboard Web
    Optional<CarStatus> findTopByOrderByIdDesc();
}