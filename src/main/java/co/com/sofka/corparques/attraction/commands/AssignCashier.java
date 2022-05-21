package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.domain.generic.Command;

public class AssignCashier extends Command {
    private final CashierId cashierId;

    public AssignCashier(CashierId cashierId) {
        this.cashierId = cashierId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
