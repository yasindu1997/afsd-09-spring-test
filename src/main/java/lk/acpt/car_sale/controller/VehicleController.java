package lk.acpt.car_sale.controller;

import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSparePartsDto;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto save = vehicleService.saveVehicle(vehicleDto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public void getAllVehicle() {

    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id) {

    }

    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable Integer id, @RequestBody VehicleDto vehicleDto) {
        vehicleDto.setId(id);

    }

    @GetMapping("/{id}")
    public void getVehicleById(@PathVariable Integer id) {

    }

    @PostMapping("/save_with_spare_parts")
    public ResponseEntity<VehicleWithSparePartsDto> saveVehicleWithSpareParts(@RequestBody VehicleWithSparePartsDto vehicleWithSparePartsDto) {
        VehicleWithSparePartsDto saved = vehicleService.saveVehicleWithSpareParts(vehicleWithSparePartsDto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
