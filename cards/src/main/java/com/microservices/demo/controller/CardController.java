package com.microservices.demo.controller;

import com.microservices.demo.dto.CardDTO;
import com.microservices.demo.dto.ContactDto;
import com.microservices.demo.model.Card;
import com.microservices.demo.service.ICardsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@AllArgsConstructor
@NoArgsConstructor
public class CardController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ContactDto contactDto;

    @Autowired
    private ICardsService iCardsService;

    @GetMapping("/cardsList")
    public ResponseEntity<Object> getAllCards(){
        try {
            return iCardsService.cardDetails();
        } catch (Exception ex) {
            System.out.println("ex " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/card")
    public ResponseEntity<Object> createCard(@RequestBody CardDTO cardDto){
        try {
            System.out.println("Controller " + cardDto.toString());
            return iCardsService.createCard(cardDto);
        } catch (Exception ex) {
            System.out.println("ex " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/build-info")
    public ResponseEntity<Object> getBuildInfo(){
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping("/contact-info")
    public ResponseEntity<Object> getContactInfo(){
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

}
