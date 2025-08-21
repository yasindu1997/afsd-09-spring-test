package lk.acpt.car_sale.service;

import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSparePartsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDto saveVehicle(VehicleDto vehicleDto);
    VehicleDto updateVehicle(VehicleDto vehicleDto);
    VehicleDto deleteVehicle(int id);
    List<VehicleDto> getVehicles();
    VehicleDto getVehicle(int id);
    VehicleWithSparePartsDto saveVehicleWithSpareParts(VehicleWithSparePartsDto vehicleWithSparePartsDto);
}
