package io.github.cursomicroservice.mscards.application.representation;

import io.github.cursomicroservice.mscards.domain.Card;
import io.github.cursomicroservice.mscards.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveCardRequest {
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal cardLimit;

    public Card toModel(){
        return new Card(name, flag, income, cardLimit);
    }
}
