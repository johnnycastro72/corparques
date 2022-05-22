package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierEmailUpdated extends DomainEvent {
    private final CashierId cashierId;
    private final Email email;

    public CashierEmailUpdated(CashierId cashierId, Email email) {
        super("corparques.sofka.cashieremailupdated");
        this.cashierId = cashierId;
        this.email = email;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Email email() {
        return email;
    }
}