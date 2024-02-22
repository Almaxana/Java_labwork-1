package ru.itmo.Core.Model;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Bank {

    public String Name;
    public UUID Id;
    public int FixedDebetPercent;
    public int DepositLength;
    public int Commission;
    public int CreditMaxNegativeSum;
    public int MaxDoubtSum;
}
