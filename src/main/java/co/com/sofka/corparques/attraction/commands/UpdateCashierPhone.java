package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateCashierPhone extends Command {
    private final CashierId cashierId;
    private final Phone phone;

    public UpdateCashierPhone(CashierId cashierId, Phone phone) {
        this.cashierId = cashierId;
        this.phone = phone;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Phone phone() {
        return phone;
    }
}
