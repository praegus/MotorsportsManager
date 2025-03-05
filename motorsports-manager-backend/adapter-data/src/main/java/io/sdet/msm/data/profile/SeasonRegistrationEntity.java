package io.sdet.msm.data.profile;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "seasonRegistrations")
public class SeasonRegistrationEntity {

    @Id
    private String name;

    private String racingClass;

    private Integer accountBalance;

    private Integer currentPosition;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private ProfileEntity profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private VehicleEntity vehicle;

    @OneToMany(mappedBy = "seasonRegistration", cascade = CascadeType.ALL)
    private List<TrackInfoEntity> trackInfo = new ArrayList<>();

    public void setTrackInfo(List<TrackInfoEntity> list) {
        list.forEach(l -> l.setSeasonRegistration(this));
        this.trackInfo = list;
    }

    @Override
    public String toString() {
        return "SeasonRegistrationEntity [name=" + name + "]";
    }
}
