package io.sdet.msm.data.profile;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "profiles")
@Entity
@Data
public class ProfileEntity {

    @Id
    private String name;
}
