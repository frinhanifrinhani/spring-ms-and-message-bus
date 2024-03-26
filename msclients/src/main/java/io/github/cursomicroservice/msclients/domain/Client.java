package io.github.cursomicroservice.msclients.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String name;
    @Column
    private Integer idade;

    public Client(String cpf, String name, Integer idade) {
        this.cpf = cpf;
        this.name = name;
        this.idade = idade;
    }
}
