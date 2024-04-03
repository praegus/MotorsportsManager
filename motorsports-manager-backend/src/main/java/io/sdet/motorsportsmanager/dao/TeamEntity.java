package io.sdet.motorsportsmanager.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Entity(name = "Team")
@Table(name = "Team")
public class TeamEntity {

    @Id
    @Column
    private String name;

    @Column(nullable = false)
    private String color;
}
