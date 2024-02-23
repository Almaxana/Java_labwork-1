package ru.itmo.Core.Model.Transactions;

import org.joda.time.DateTime;
import org.joda.time.Days;
import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Accounts.Credit;
import ru.itmo.Core.Model.Accounts.Debet;
import ru.itmo.Core.Model.Accounts.Deposit;
import ru.itmo.Core.Model.Customer;

public class MoveMoneyTransaction extends Transaction{
    public MoveMoneyTransaction(Account fromAccount,Account toAccount, Customer _customer, int sum){
        super(sum);
        FromAccount = fromAccount;
        ToAccount = toAccount;
        customer = _customer;
    }
    public Account FromAccount;
    public Account ToAccount;
    public Customer customer;
    @Override
    public boolean Execute() {
        if (customer.Address == null || customer.Passport == null) return false;

        if (FromAccount instanceof Debet debet) {
            if (debet.CurrentSum >= sum) {
                FromAccount.CurrentSum -= sum;
                ToAccount.CurrentSum +=sum;
                return true;
            }
            return false;
        }
        if (FromAccount instanceof Deposit deposit){
            if (Days.daysBetween(deposit.dateOfStart, new DateTime()).getDays() > deposit.Length){
                FromAccount.CurrentSum -= sum;
                ToAccount.CurrentSum +=sum;
                return true;
            }
            return false;
        }
        if (FromAccount instanceof Credit credit){
            if (FromAccount.CurrentSum - sum > credit.MAxNegativeSum) {
                FromAccount.CurrentSum -= sum;
                ToAccount.CurrentSum +=sum;
                return true;
            }
            return false;
        }

        return true;
    }

    @Override
    public void Undo() {
        FromAccount.CurrentSum += sum;
        ToAccount.CurrentSum -= sum;
    }
}
