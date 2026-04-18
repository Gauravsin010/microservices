package com.example.loans.service;

import org.springframework.http.ResponseEntity;

public interface ILoansService {

    ResponseEntity<Object> getLoansDetails(String mobileNumber);
    ResponseEntity<Object> createLoan(String mobileNumber);
}
