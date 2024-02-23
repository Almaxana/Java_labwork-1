package ru.itmo.Core.Common;

import org.joda.time.DateTime;
import ru.itmo.Core.Model.Accounts.Account;
import ru.itmo.Core.Model.Customer;

import java.util.Calendar;
import java.util.UUID;

public class CurrentStateManager {
    public Customer CustomerInSystem;
    public Account CurrentAccount;
    public DateTime CurrentData;
}
