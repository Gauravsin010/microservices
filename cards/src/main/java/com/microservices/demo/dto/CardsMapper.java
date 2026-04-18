package com.microservices.demo.dto;

import com.microservices.demo.model.Card;

public class CardsMapper {

    public static Card MapToCard(CardDTO cardDTO, Card card){
        card.setCard_name(cardDTO.getCardName());
        card.setCard_type(cardDTO.getCardType());
        card.setCard_limit(cardDTO.getLimit());
        return card;
    }


}
