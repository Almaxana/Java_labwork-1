package ru.itmo.DataAccess;

import ru.itmo.Core.Model.Bank;
import ru.itmo.Core.Repositories.IBankRepository;

import java.util.ArrayList;

public class BanksRepository implements IBankRepository {
    private ArrayList<Bank> banks;
    public BanksRepository(){
        banks = new ArrayList<>();
    }
    @Override
    public Bank GetBankByName(String name) {
        return banks.stream().filter(elem->elem.Name.equals(name)).findFirst().orElse(null);
    }

    @Override
    public boolean AddBank(Bank bank) {
        if (GetBankByName(bank.Name) != null) return false;
        banks.add(bank);
        return true;
    }
}
