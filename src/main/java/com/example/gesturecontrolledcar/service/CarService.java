package com.example.gesturecontrolledcar.service;

import com.example.gesturecontrolledcar.model.CarStatus;
import com.example.gesturecontrolledcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    // Hàm phụ trợ: Dịch tiếng Anh sang tiếng Việt
    private String translateDirection(String rawDirection) {
        if (rawDirection == null) return "Dừng";

        switch (rawDirection.toLowerCase()) {
            case "forward": return "Tiến";
            case "backward": return "Lùi";
            case "left": return "Trái";
            case "right": return "Phải";
            case "stop": return "Dừng";
            default: return "Dừng"; // Bắt lỗi an toàn
        }
    }

    // Nghiệp vụ 1: Nhận dữ liệu thô, xử lý dịch thuật rồi mới lưu
    public void saveStatus(CarStatus status) {
        // Lấy chữ tiếng Anh ESP32 gửi lên
        String englishDir = status.getDirection();

        // Dịch sang tiếng Việt
        String vietnameseDir = translateDirection(englishDir);

        // Cập nhật lại đối tượng trước khi cất vào Database
        status.setDirection(vietnameseDir);

        repository.save(status);
    }

    // Nghiệp vụ 2: Lấy trạng thái mới nhất cho Web
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