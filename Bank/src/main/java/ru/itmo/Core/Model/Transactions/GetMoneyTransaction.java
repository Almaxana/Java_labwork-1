package ru.itmo.Core.Model.Transactions;

import ru.itmo.Core.Model.Accounts.Account;
public class GetMoneyTransaction extends Transaction{
    public GetMoneyTransaction(Account _account, int sum){
        super(sum);
        account = _account;
    }
    public Account account;
    @Override
    public void Execute() {
        account.CurrentSum -= sum;
    }

    @Override
    public void Undo() {
        account.CurrentSum += sum;
    }
}
