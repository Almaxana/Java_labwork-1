package ru.itmo.Core.Services;

import lombok.AllArgsConstructor;
import ru.itmo.Core.Model.Bank;
import ru.itmo.Core.Repositories.IBankRepository;

import java.util.UUID;

@AllArgsConstructor
public class CentralBank {
    IBankRepository bankRepository;
    public boolean CreateBank(String name,  int maxDoubtSum, int depositLength, int commission, int fixedDebetPercent, UUID id, int creditMaxNegativeSum) {
        return bankRepository.AddBank(new Bank(name, id, fixedDebetPercent, depositLength, commission, creditMaxNegativeSum, maxDoubtSum));
    }


}
