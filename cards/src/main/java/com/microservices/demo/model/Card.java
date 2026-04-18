package com.microservices.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long card_id;

    @Column(name = "card_name")
    private String card_name;

    @Column(name = "card_type")
    private String card_type;

    @Column(name = "card_limit")
    private Long card_limit;

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public Long getCard_limit() {
        return card_limit;
    }

    public void setCard_limit(Long card_limit) {
        this.card_limit = card_limit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", card_name='" + card_name + '\'' +
                ", card_type='" + card_type + '\'' +
                ", card_limit=" + card_limit +
                '}';
    }
}
