package io.sdet.msm.data.profile;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trackRecords")
public class TrackRecordEntity {

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
