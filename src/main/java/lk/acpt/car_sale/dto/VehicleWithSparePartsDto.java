package lk.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleWithSparePartsDto {
    private String brand;
    private String model;
    private double engineCap;
    private int noOfGears;
    private List<SparePartDto> spareParts;
}
