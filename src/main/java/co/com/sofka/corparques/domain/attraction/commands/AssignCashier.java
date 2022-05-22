package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.CashierId;
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
