package com.microservices.demo.service;

import com.microservices.demo.dto.CardDTO;
import com.microservices.demo.model.Card;
import org.springframework.http.ResponseEntity;

public interface ICardsService {

    public ResponseEntity<Object> cardDetails();

    public ResponseEntity<Object> createCard(CardDTO cardDto);

}
