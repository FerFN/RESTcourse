package com.example.banco.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GruposRepositorio extends JpaRepository<Grupo, Long> {
    Grupo findByName(String name);
}
