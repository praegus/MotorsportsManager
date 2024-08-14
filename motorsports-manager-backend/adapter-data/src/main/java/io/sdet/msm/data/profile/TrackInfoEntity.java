package io.sdet.msm.data.profile;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trackInfos")
public class TrackInfoEntity{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String status;

    private Integer prizeMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="season_registration_id")
    private SeasonRegistrationEntity seasonRegistration;

}
