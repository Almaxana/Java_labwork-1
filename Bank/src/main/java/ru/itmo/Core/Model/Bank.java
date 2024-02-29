package ru.itmo.Core.Model;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Bank {

    public String Name;
    public UUID Id;
    public int FixedDebetPercent;
    public int Commission;
    public int CreditMaxNegativeSum;
    public int MaxDoubtSum;
    public int DepositPercentBorder;

    public int CountDepositPercent(int startSum){
        if (startSum < 50000) return DepositPercentBorder;
        else return DepositPercentBorder*2;
    }
}
