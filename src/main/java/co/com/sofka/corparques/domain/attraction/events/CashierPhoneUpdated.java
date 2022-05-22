package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierPhoneUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final CashierId cashierId;
    private final Phone phone;

    public CashierPhoneUpdated(AttractionId attractionId, CashierId cashierId, Phone phone) {
        super("corparques.sofka.cashierphoneupdated");
        this.attractionId = attractionId;
        this.cashierId = cashierId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Phone phone() {
        return phone;
    }
}
