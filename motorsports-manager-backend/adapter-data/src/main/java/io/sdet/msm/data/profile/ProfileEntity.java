package io.sdet.msm.data.profile;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "profiles")
public class ProfileEntity {
    @Id
    private String name;
}
