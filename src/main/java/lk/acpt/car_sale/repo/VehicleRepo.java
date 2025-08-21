package lk.acpt.car_sale.repo;

import lk.acpt.car_sale.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByBrand(String brand);

    List<Vehicle> getVehicleByBrandAndModel(String brand, String model);
}
