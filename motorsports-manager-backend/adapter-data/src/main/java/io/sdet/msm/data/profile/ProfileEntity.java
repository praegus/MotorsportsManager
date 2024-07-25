package io.sdet.msm.data.profile;

import io.sdet.msm.data.organization.OrganizationEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "profiles")
public class ProfileEntity {
    @Id
    private String name;

    @OneToMany(
            mappedBy = "profile",
            cascade = CascadeType.ALL
    )
    private List<OrganizationEntity> organizations = new ArrayList<>();
}
