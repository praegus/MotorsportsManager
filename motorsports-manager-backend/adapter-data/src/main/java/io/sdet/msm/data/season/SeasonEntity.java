package io.sdet.msm.data.season;

import io.sdet.msm.data.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "seasons")
public class SeasonEntity {

    @Id
    private String name;

    private String racingClass;

    private String accountBalance;

    private String Vehicle;

    @ManyToMany(mappedBy = "seasons", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<ProfileEntity> profiles;
}
