package io.github.cursomicroservice.mscards.application;

import io.github.cursomicroservice.mscards.application.representation.CardsByClientResponse;
import io.github.cursomicroservice.mscards.application.representation.SaveCardRequest;
import io.github.cursomicroservice.mscards.domain.Card;
import io.github.cursomicroservice.mscards.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsResource {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity register(@RequestBody SaveCardRequest request){
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsIncomeUntil(@RequestParam("income") Long income){
        List<Card> list = cardService.getIncomeCardLessOrEqual(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> getCardsByClient(@RequestParam("cpf") String cpf){

       List<ClientCard> list = clientCardService.listCardByCpf(cpf);
       List<CardsByClientResponse> resultList = list.stream()
               .map(CardsByClientResponse::fromModel)
               .collect(Collectors.toList());

       return ResponseEntity.ok(resultList);
    }
}
