package com.example.loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loans extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column
    private String mobileNumber;

    @Column
    private String loanNumber;

    @Column
    private String loanType;

    @Column
    private int totalLoan;

    @Column
    private int amountPaid;

    @Column
    private int outstandingAmount;
}
