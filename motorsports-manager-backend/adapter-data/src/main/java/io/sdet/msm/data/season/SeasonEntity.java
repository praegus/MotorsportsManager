package io.sdet.msm.data.season;

import io.sdet.msm.data.profile.ProfileEntity;
import io.sdet.msm.data.track.TrackEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String racingClass;

    private String accountBalance;

    private String Vehicle;

    @ManyToMany(
            mappedBy = "seasons"
    )
    private Set<ProfileEntity> profiles;

    @ManyToMany
    @JoinTable(
            name = "season_track",
            joinColumns = @JoinColumn(name = "season_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private List<TrackEntity> tracks;
}
