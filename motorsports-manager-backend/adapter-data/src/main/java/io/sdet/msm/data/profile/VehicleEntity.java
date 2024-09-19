package io.sdet.msm.data.profile;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String wheels;

    private String engine;

    private String chassis;

    @OneToOne(mappedBy = "vehicle")
    private SeasonRegistrationEntity seasonRegistration;

}
