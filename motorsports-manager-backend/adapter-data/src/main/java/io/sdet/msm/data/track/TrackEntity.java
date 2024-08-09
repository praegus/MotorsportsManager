package io.sdet.msm.data.track;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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

}
