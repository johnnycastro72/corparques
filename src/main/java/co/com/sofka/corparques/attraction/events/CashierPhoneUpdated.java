package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierPhoneUpdated extends DomainEvent {
    private final CashierId cashierId;
    private final Phone phone;

    public CashierPhoneUpdated(CashierId cashierId, Phone phone) {
        super("corparques.sofka.cashierphoneupdated");
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
