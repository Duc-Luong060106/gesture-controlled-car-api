package com.example.gesturecontrolledcar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_status_history")
public class CarStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int distance;
    private int speed;
    private String direction;
    private boolean isSOS;

    private LocalDateTime timestamp = LocalDateTime.now();

    public CarStatus() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public boolean getIsSOS() { return isSOS; }
    public void setIsSOS(boolean isSOS) { this.isSOS = isSOS; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
