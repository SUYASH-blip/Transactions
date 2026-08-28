package org.example.transactions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    private String name;

    public void WithdrawAccount(BigDecimal amount){
        if(amount == null || amount.signum() <= 0){
            throw new RuntimeException("Invalid Amount");
        }
        if(balance.compareTo(amount)<0){
            throw new RuntimeException("Insufficient Balance");
        }
         balance = balance.subtract(amount);
    }


    public void DebitAccount(BigDecimal amount){
        if(amount == null || amount.signum() <= 0){
            throw new RuntimeException("Invalid Amount");
        }
        balance = balance.add(amount);
    }


}
