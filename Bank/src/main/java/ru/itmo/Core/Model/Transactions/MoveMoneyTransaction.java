package ru.itmo.Core.Model.Transactions;

import ru.itmo.Core.Model.Accounts.Account;

public class MoveMoneyTransaction extends Transaction{
    public MoveMoneyTransaction(Account fromAccount,Account toAccount, int sum){
        super(sum);
        FromAccount = fromAccount;
        ToAccount = toAccount;
    }
    public Account FromAccount;
    public Account ToAccount;
    @Override
    public void Execute() {
        FromAccount.CurrentSum -= sum;
        ToAccount.CurrentSum += sum;
    }

    @Override
    public void Undo() {
        FromAccount.CurrentSum += sum;
        ToAccount.CurrentSum -= sum;
    }
}
