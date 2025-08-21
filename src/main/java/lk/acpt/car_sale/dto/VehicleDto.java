package lk.acpt.car_sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Integer id;
    private String brand;
    private String model;
    private double engineCap;
    private int noOfGears;
}
