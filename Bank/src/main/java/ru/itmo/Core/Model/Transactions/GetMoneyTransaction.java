package ru.itmo.Core.Model.Transactions;

import org.joda.time.DateTime;
import org.joda.time.Days;
import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Accounts.Credit;
import ru.itmo.Core.Model.Accounts.Debet;
import ru.itmo.Core.Model.Accounts.Deposit;
import ru.itmo.Core.Model.Customer;

public class GetMoneyTransaction extends Transaction{
    public GetMoneyTransaction(Account _account, Customer _customer, int sum){
        super(sum);
        account = _account;
        customer = _customer;
    }
    public Account account;
    public Customer customer;
    @Override
    public boolean Execute() {
        if (customer.Address == null || customer.Passport == null) return false;

        if (account instanceof Debet debet) {
            if (debet.CurrentSum >= sum) {
                account.CurrentSum -= sum;
                return true;
            }
            return false;
        }
        if (account instanceof Deposit deposit){
            if (Days.daysBetween(deposit.dateOfStart, new DateTime()).getDays() > deposit.Length){
                account.CurrentSum -= sum;
                return true;
            }
            return false;
        }
        if (account instanceof Credit credit){
            if (account.CurrentSum - sum > credit.MAxNegativeSum) {
                account.CurrentSum -= sum;
                return true;
            }
            return false;
        }

        return true;
    }

    @Override
    public void Undo() {
        account.CurrentSum += sum;
    }
}
