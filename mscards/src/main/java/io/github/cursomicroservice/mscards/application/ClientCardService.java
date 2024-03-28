package io.github.cursomicroservice.mscards.application;

import io.github.cursomicroservice.mscards.domain.ClientCard;
import io.github.cursomicroservice.mscards.infra.repository.ClientCardRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    public List<ClientCard> listCardByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
