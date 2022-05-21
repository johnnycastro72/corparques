package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierPhoneUpdated extends DomainEvent {
    public CashierPhoneUpdated(CashierId cashierId, Phone phone) {
        super("corparques.sofka.cashierphoneupdated");
    }
}
