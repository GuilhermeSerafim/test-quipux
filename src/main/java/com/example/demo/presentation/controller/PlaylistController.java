package com.example.demo.presentation.controller;

import com.example.demo.application.service.PlaylistService;
import com.example.demo.domain.model.Playlist;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    private final PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist criar(@Valid @RequestBody Playlist playlist) {
        return service.salvar(playlist);
    }

    @GetMapping
    public List<Playlist> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{listName}")
    public Playlist buscarPorNome(@PathVariable String listName) {
        return service.buscarPorNome(listName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista não encontrada"));
    }

    @DeleteMapping("/{listName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String listName) {
        if (!service.deletarPorNome(listName)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista não encontrada");
        }
    }
}
