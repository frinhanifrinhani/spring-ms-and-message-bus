package io.github.cursomicroservice.msclients.application;

import io.github.cursomicroservice.msclients.application.representation.ClientSaveRequest;
import io.github.cursomicroservice.msclients.domain.Client;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clients")
//@RequiredArgsConstructor
public class ClientResource {

    @Autowired
    private final ClientService service;

    private ClientResource(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request) {
        Client client = request.toModel();
        service.save(client);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosClient(@RequestParam("cpf") String cpf) {
        Optional<Client> client = service.getByCPF(cpf);
        if (cpf.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);

    }

}
