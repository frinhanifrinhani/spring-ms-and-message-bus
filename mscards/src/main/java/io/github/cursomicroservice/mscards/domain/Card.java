package io.github.cursomicroservice.mscards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CARD")
@Data
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
    private BigDecimal cardlimit;

    public Card(String name,
                CardFlag flag,
                BigDecimal income,
                BigDecimal cardlimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.cardlimit = cardlimit;
    }
}
