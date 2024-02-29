package ru.itmo.Core.Model.Accounts;

import org.joda.time.DateTime;

import java.util.UUID;

public class Credit extends Account{
    public int MAxNegativeSum;
    public float Commission;
    public Credit(UUID id, int currentSum, int maxNegativeSum, UUID customerID, UUID bankId, float commission) {
        super(id, currentSum, customerID, bankId);
        MAxNegativeSum = maxNegativeSum;
        Commission = commission;
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
            newBalance-=Commission/36500*(newBalance);
        }
        return newBalance;
    }
}
