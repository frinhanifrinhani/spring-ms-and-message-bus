package io.github.cursomicroservice.mscards.application.representation;

import io.github.cursomicroservice.mscards.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByClientResponse {

    private String name;
    private String flag;
    private BigDecimal limitReleased;

    public static CardsByClientResponse fromModel(ClientCard model){
        return new CardsByClientResponse(
              model.getCard().getName(),
              model.getCard().getFlag().toString(),
              model.getCardLimit()
        );
    }
}
