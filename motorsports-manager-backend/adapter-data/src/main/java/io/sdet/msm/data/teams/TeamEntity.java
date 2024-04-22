package io.sdet.msm.data.teams;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "team")
@Entity
@Data
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slogan;
}
