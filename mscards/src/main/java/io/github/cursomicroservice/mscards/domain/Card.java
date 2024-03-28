package io.github.cursomicroservice.mscards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CARD")
@Data
@RequiredArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    @Column
    private BigDecimal income;
    @Column
    private BigDecimal cardLimit;

    public Card(String name,
                CardFlag flag,
                BigDecimal income,
                BigDecimal cardLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.cardLimit = cardLimit;
    }
}
