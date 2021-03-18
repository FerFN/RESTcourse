package com.example.banco.web;

import com.example.banco.model.Grupo;
import com.example.banco.model.GruposRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GrupoController {
    private GruposRepositorio gruposRepositorio;

    public GrupoController(GruposRepositorio grupoRepositorio) {
        this.gruposRepositorio = grupoRepositorio;
    }

    @GetMapping("/grupos")
    Collection<Grupo> grupos() {
        return gruposRepositorio.findAll();
    }

    @GetMapping("/grupo/{id}")
    ResponseEntity<?> getGrupo(@PathVariable Long id) {
        Optional<Grupo> grupo = gruposRepositorio.findById(id);
        return grupo.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/grupo")
    ResponseEntity<Grupo> createGroup(@RequestBody Grupo grupo) throws URISyntaxException {
        Grupo resultado = gruposRepositorio.save(grupo);
        return ResponseEntity.created(new URI("api/grupo/" + resultado.getId())).body(resultado);
    }

    /*@PutMapping("/grupo/{id}")
    ResponseEntity<Grupo> updateGroup(@RequestBody Grupo grupo) {
        //log.info("Request to update group: {}", grupo);
        Grupo result = gruposRepositorio.save(grupo);
        return ResponseEntity.ok().body(result);
    }*/

    @PutMapping("/grupo/{id}")
    Grupo updateGroup(@RequestBody Grupo grupoDatos, @PathVariable Long id) {
        return gruposRepositorio.findById(id).map(grupo -> {
            grupo.setName(grupoDatos.getName());
            grupo.setAddress(grupoDatos.getAddress());
            grupo.setCity(grupoDatos.getCity());
            grupo.setCountry(grupoDatos.getCountry());
            return gruposRepositorio.save(grupo);
        }).orElseGet(() -> {
            grupoDatos.setId(id);
            return gruposRepositorio.save(grupoDatos);
        });
    }

    @DeleteMapping("/grupo/{id}")
    public  ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        gruposRepositorio.deleteById(id);
        return ResponseEntity.ok().build();
    }
}