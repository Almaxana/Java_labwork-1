package ru.itmo.Core.Model.Accounts;

import org.joda.time.DateTime;

import java.util.UUID;

public class Deposit extends Account{
    public int StartSum;
    public int Length;
    public float Percent;
    public Deposit(UUID id, int currentSum, int startSum, int length, UUID customerID, UUID bankId, float percent) {
        super(id, currentSum, customerID, bankId);
        StartSum = startSum;
        Length = length;
        Percent = percent;
    }

    @Override
    public float CountBalanceOverPeriod(int days, DateTime currentData) {
        DateTime tempData = new DateTime(currentData.getYear(), currentData.getMonthOfYear(), currentData.getDayOfMonth(), currentData.getHourOfDay(), currentData.getMinuteOfHour());
        tempData = tempData.plusDays(days);
        int lastMonth = tempData.getMonthOfYear();
        tempData = new DateTime(currentData.getYear(), currentData.getMonthOfYear(), currentData.getDayOfMonth(), currentData.getHourOfDay(), currentData.getMinuteOfHour());
        float newBalance = CurrentSum;
        for (int i = 1; i <= days; ++i){
            tempData = tempData.plusDays(1);
            if (tempData.getDayOfMonth() == 0 && tempData.getMonthOfYear() == lastMonth) return newBalance;
            newBalance+=(Percent)/36500*(newBalance);
        }
        return newBalance;
    }
}
