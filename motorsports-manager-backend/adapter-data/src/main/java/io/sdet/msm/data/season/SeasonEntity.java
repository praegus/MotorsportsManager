package io.sdet.msm.data.season;

import io.sdet.msm.data.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "seasons")
public class SeasonEntity {

    @Id
    private String name;

    private String racingClass;

    private Integer accountBalance;

    private String vehicle;

    @ManyToMany(mappedBy = "seasons", cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
    private List<ProfileEntity> profiles;
}
