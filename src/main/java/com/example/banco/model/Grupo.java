package com.example.banco.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_groups")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;

    //@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //private Set<Evento> events;

}