package ru.itmo.Core.Model.Transactions;

import ru.itmo.Core.Model.Accounts.Account;

public class AddMoneyTransaction extends Transaction{
    public AddMoneyTransaction(Account _account, int sum){
        super(sum);
        account = _account;
    }
    public Account account;
    @Override
    public boolean Execute() {
        account.CurrentSum += sum;
        return true;
    }

    @Override
    public void Undo() {
        if (!Canceled) {
            account.CurrentSum -= sum;
            Canceled = true;
        }

    }
}
