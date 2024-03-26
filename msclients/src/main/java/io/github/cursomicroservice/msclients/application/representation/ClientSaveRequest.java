package io.github.cursomicroservice.msclients.application.representation;

import io.github.cursomicroservice.msclients.domain.Client;
import io.github.cursomicroservice.msclients.infra.repository.ClientRepository;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
