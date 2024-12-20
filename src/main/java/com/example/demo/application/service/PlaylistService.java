package com.example.demo.application.service;
import com.example.demo.domain.model.Playlist;
import com.example.demo.domain.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository repository;

    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }

    public Playlist salvar(Playlist playlist) {
        if (playlist.getNome() == null || playlist.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da lista não pode ser vazio.");
        }
        return repository.save(playlist);
    }

    public List<Playlist> listarTodos() {
        return repository.findAll();
    }

    public Optional<Playlist> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public void deletarPorNome(String nome) {
        Playlist playlist = repository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Lista não encontrada."));
        repository.delete(playlist);
    }
}