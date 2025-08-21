package lk.acpt.car_sale.service.impl;

import lk.acpt.car_sale.dto.SparePartDto;
import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSparePartsDto;
import lk.acpt.car_sale.entity.SparePart;
import lk.acpt.car_sale.entity.Vehicle;
import lk.acpt.car_sale.repo.VehicleRepo;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleRepo vehicleRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle save = vehicleRepo.save(new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(),
                vehicleDto.getModel(), vehicleDto.getEngineCap(), vehicleDto.getNoOfGears()));
        return new VehicleDto(save.getId(), save.getBrand(), save.getModel(),
                save.getEngineCap(), save.getNoOfGears());
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> byId = vehicleRepo.findById(vehicleDto.getId());

        if (byId.isPresent()) {
            Vehicle vehicle = byId.get();
            vehicle.setBrand(vehicleDto.getBrand());
            vehicle.setModel(vehicleDto.getModel());
            vehicle.setEngineCap(vehicleDto.getEngineCap());
            vehicle.setNoOfGears(vehicleDto.getNoOfGears());

            Vehicle update = vehicleRepo.save(vehicle);
            return new VehicleDto(update.getId(), update.getBrand(), update.getModel(),
                    update.getEngineCap(), update.getNoOfGears());
        } else {
            return null;
        }
    }

    @Override
    public VehicleDto deleteVehicle(int id) {

        Optional<Vehicle> byId = vehicleRepo.findById(id);

        if (byId.isPresent()) {
            vehicleRepo.deleteById(id);
            Vehicle vehicle = byId.get();
            return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                    vehicle.getEngineCap(), vehicle.getNoOfGears());
        } else {
            return null;
        }
    }

    @Override
    public List<VehicleDto> getVehicles() {
        List<Vehicle> all = vehicleRepo.findAll();

        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : all) {
            vehicleDtos.add(new VehicleDto(vehicle.getId(), vehicle.getBrand(),
                    vehicle.getModel(), vehicle.getEngineCap(), vehicle.getNoOfGears()));
        }

        return vehicleDtos;
    }

    @Override
    public VehicleDto getVehicle(int id) {
        vehicleRepo.findByBrand("Toyota");
        return null;
    }

    @Override
    public VehicleWithSparePartsDto saveVehicleWithSpareParts(VehicleWithSparePartsDto vehicleWithSparePartsDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleWithSparePartsDto.getBrand());
        vehicle.setModel(vehicleWithSparePartsDto.getModel());
        vehicle.setEngineCap(vehicleWithSparePartsDto.getEngineCap());
        vehicle.setNoOfGears(vehicleWithSparePartsDto.getNoOfGears());

        ArrayList<SparePart> list = new ArrayList<>();

        for (SparePartDto spDto : vehicleWithSparePartsDto.getSpareParts()) {
            list.add(new SparePart(spDto.getId(), spDto.getName(), spDto.getPrice(), vehicle));
        }

        vehicle.setSpareParts(list);
        Vehicle save = vehicleRepo.save(vehicle);

        return vehicleWithSparePartsDto;
    }
}
