package com.example.banco;

import com.example.banco.model.Evento;
import com.example.banco.model.Grupo;
import com.example.banco.model.GruposRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer { //implements CommandLineRunner {
    /*private final GruposRepositorio repositorio;

    public Initializer(GruposRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Clientes","Empleados","Ejecutivos","Gerentes").forEach(name -> repositorio.save(new Grupo(name)));

        Grupo test = repositorio.findByName("Clientes");
        Evento e = Evento.builder().title("Test restful").description("testing event").build();
        test.setEvents(Collections.singleton(e));
        repositorio.save(test);

        repositorio.findAll().forEach(System.out::println);
    }*/
}