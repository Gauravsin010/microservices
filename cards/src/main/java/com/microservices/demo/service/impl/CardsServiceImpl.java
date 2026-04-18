package com.microservices.demo.service.impl;

import com.microservices.demo.dto.CardDTO;
import com.microservices.demo.dto.CardsMapper;
import com.microservices.demo.model.Card;
import com.microservices.demo.repo.CardRepo;
import com.microservices.demo.service.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements ICardsService {

    @Autowired
    private CardRepo cardRepo;

    @Override
    public ResponseEntity<Object> cardDetails() {
        List<Card> cardsList = cardRepo.findAll();

        if(!cardsList.isEmpty()){
            return new ResponseEntity<>(cardsList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> createCard(CardDTO cardDto) {

        System.out.println("Request " + cardDto.toString());

        Card card = CardsMapper.MapToCard(cardDto, new Card());
        Card response = cardRepo.save(card);

        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
