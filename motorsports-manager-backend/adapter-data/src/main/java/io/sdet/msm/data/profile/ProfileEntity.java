package io.sdet.msm.data.profile;

import io.sdet.msm.data.season.SeasonEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "profiles_seasons",
            joinColumns = {@JoinColumn(name = "profile_name")},
            inverseJoinColumns = {@JoinColumn(name = "season_id")}
    )
    private Set<SeasonEntity> seasons;
}
