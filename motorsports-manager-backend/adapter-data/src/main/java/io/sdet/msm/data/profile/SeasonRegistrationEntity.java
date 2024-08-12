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
    @GeneratedValue
    private Long id;

    private String name;

    private String racingClass;

    private Integer accountBalance;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private ProfileEntity profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private VehicleEntity vehicle;

    @OneToMany(mappedBy = "seasonRegistration", cascade = CascadeType.ALL)
    private List<TrackRecordEntity> trackRecords = new ArrayList<>();

    public void setTrackRecords(List<TrackRecordEntity> list) {
        list.forEach(l -> l.setSeasonRegistration(this));
        this.trackRecords = list;
    }
}
