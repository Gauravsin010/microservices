package com.example.loans.controller;

import com.example.loans.service.ILoansService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoansController {

    @Autowired
    private ILoansService iLoansService;

    @GetMapping("/loan/{mobileNumber}")
    public ResponseEntity<Object> getLoanDetails(@PathVariable
                                                 @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber){
        return iLoansService.getLoansDetails(mobileNumber);
    }

    @PostMapping("/loan/{mobileNumber}")
    public ResponseEntity<Object> createLoans(@PathVariable
                                                 @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber){
        return iLoansService.createLoan(mobileNumber);
    }
}
