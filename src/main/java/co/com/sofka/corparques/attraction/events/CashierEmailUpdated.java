package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierEmailUpdated extends DomainEvent {
    public CashierEmailUpdated(CashierId cashierId, Email email) {
        super("corparques.sofka.cashieremailupdated");
    }
}
