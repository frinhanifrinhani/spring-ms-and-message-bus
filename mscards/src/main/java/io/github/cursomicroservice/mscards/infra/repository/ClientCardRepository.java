package io.github.cursomicroservice.mscards.infra.repository;

import io.github.cursomicroservice.mscards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long>{
    List<ClientCard> findByCpf(String cpf);
}
