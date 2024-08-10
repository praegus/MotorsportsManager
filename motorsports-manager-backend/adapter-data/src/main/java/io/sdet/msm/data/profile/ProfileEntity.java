package io.sdet.msm.data.profile;

import io.sdet.msm.data.season.SeasonEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    private String name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "profile_season",
            joinColumns = {@JoinColumn(name = "profile_name")},
            inverseJoinColumns = {@JoinColumn(name = "season_name")}
    )
    private List<SeasonEntity> seasons;
}
