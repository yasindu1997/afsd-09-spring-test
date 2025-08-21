package lk.acpt.car_sale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String model;
    private double engineCap;
    private int noOfGears;

    public Vehicle(Integer id, String brand, String model, double engineCap, int noOfGears) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engineCap = engineCap;
        this.noOfGears = noOfGears;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    List<SparePart> spareParts;
}
