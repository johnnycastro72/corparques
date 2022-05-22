package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierEmailUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final CashierId cashierId;
    private final Email email;

    public CashierEmailUpdated(AttractionId attractionId, CashierId cashierId, Email email) {
        super("corparques.sofka.cashieremailupdated");
        this.attractionId = attractionId;
        this.cashierId = cashierId;
        this.email = email;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Email email() {
        return email;
    }
}
