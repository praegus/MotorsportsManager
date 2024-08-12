package io.sdet.msm.data.profile;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<SeasonRegistrationEntity> seasonRegistrations = new ArrayList<>();

    /**
     * overwrite mapstruct generated method so we can immediately setup up the link between child and parents
     */
    public void setSeasonRegistrations(List<SeasonRegistrationEntity> list) {
        list.forEach(l -> l.setProfile(this));
        this.seasonRegistrations = list;
    }
}
