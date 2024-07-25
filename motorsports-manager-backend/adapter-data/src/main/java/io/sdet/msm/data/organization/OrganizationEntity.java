package io.sdet.msm.data.organization;

import io.sdet.msm.data.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "organizations")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_name")
    private ProfileEntity profile;
}
