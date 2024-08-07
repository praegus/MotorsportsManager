package io.sdet.msm.data.track;


import io.sdet.msm.data.profile.ProfileEntity;
import io.sdet.msm.data.season.SeasonEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tracks")
public class TrackEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String status;

    private Integer prizeMoney;

    @ManyToMany(
            mappedBy = "tracks"
    )
    private List<SeasonEntity> seasons;

}
