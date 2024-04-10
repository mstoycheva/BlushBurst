package com.dzi.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "season_name")
    private String seasonName;

    public Season(Integer id, String seasonName) {
        this.id = id;
        this.seasonName = seasonName;
    }

    public Season() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}
