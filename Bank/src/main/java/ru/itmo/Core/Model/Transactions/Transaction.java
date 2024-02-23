package ru.itmo.Core.Model.Transactions;


public abstract class Transaction {
    public Transaction(int _sum){
        sum = _sum;
    }
    public int sum;
    boolean Canceled = false;
    public abstract boolean Execute();
    public abstract void Undo();
}
