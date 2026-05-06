package com.example.loans.controller;

import com.example.loans.dto.ContactDto;
import com.example.loans.service.ILoansService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class LoansController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ContactDto contactDto;

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

    @GetMapping("/build-info")
    public ResponseEntity<Object> getBuildInfo(){
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping("/contact-info")
    public ResponseEntity<Object> getContactInfo(){
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }
}
