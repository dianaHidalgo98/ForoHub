package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registers a new topic in the database that gives access to the other endpoints.")
    public ResponseEntity<DataTopicResponse> registrarTopico(@RequestBody @Valid DataTopicRegister dataTopicRegister,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(dataTopicRegister));
        DataTopicResponse dataTopicResponse = new DataTopicResponse(topico.getTitle(), topico.getContent(),
                topico.getCreatedAt(), topico.isStatus(), topico.getAuthor(), topico.getCourse());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dataTopicResponse);

    }

    @GetMapping
    @Operation(summary = "Gets the list of topics")
    public ResponseEntity<Page<Topico>> topicList(@PageableDefault(size = 2) Pageable website) {
        return ResponseEntity.ok(topicoRepository.findAll(website));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets the topical records with ID")
    public ResponseEntity<DataTopicResponse> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var dataTopico = new DataTopicResponse(topico.getTitle(), topico.getContent(),
                topico.getCreatedAt(), topico.isStatus(), topico.getAuthor(), topico.getCourse());
        return ResponseEntity.ok(dataTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Update the data of an existing topic")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DataTopicUpdate dataTopicUpdate) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(dataTopicUpdate);
        return ResponseEntity.ok(new DataTopicResponse(topico.getTitle(), topico.getContent(),
                topico.getCreatedAt(), topico.isStatus(), topico.getAuthor(), topico.getCourse()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Delete a registered topic")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
