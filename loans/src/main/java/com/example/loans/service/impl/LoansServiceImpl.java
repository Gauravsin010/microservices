package com.example.loans.service.impl;

import com.example.loans.entity.Loans;
import com.example.loans.repo.LoansRepo;
import com.example.loans.service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements ILoansService {

    @Autowired
    private LoansRepo loansRepo;


    @Override
    public ResponseEntity<Object> getLoansDetails(String mobileNumber){
        Optional<Loans> response = loansRepo.findByMobileNumber(mobileNumber);
        return response.<ResponseEntity<Object>>map
                (loans -> new ResponseEntity<>(loans, HttpStatus.OK)).orElseGet
                (() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Override
    public ResponseEntity<Object> createLoan(String mobileNumber) {
        Optional<Loans> response = loansRepo.findByMobileNumber(mobileNumber);
        if(response.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Loans newLoan = new Loans();
            long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
            newLoan.setLoanNumber(Long.toString(randomLoanNumber));
            newLoan.setMobileNumber(mobileNumber);
            newLoan.setLoanType("HomeLoan");
            newLoan.setTotalLoan(100000);
            newLoan.setAmountPaid(0);
            newLoan.setOutstandingAmount(100000);
            Loans resp = loansRepo.save(newLoan);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        }
    }
}
