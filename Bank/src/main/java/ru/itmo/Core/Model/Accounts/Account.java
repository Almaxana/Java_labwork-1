package ru.itmo.Core.Model.Accounts;

import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class Account {
    public Account(UUID id, int currentSum, UUID customerId, UUID bankId){
        Id = id;
        CurrentSum = currentSum;
        CustomerId = customerId;
        BankId = bankId;
        dateOfStart = new DateTime();
    }
    public UUID Id;
    public int CurrentSum;
    public UUID CustomerId;
    public UUID BankId;
    public DateTime dateOfStart;
    public abstract float CountBalanceOverPeriod(int days, DateTime currentData);

}
