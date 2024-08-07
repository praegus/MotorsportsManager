package io.sdet.msm.data.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String wheels;

    private String engine;

    private String chassis;

}
