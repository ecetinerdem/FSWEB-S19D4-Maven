package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movie", schema = "fsweb")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message ="film adı null olamaz")
    private String name;

    @Column(name = "director_name")
    @NotNull(message ="yönetmen adı null olamaz")
    private String directorName;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "release_Date")
    private LocalDate releaseDate;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "movie_actor", schema = "fsweb", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    public void addMovie(Actor actor) {
        if(actors == null) {
            actors = new ArrayList<>();
        }
        actors.add(actor);
    }



}