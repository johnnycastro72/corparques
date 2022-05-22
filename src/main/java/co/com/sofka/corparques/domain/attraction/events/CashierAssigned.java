package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierAssigned extends DomainEvent {
    private final AttractionId attractionId;
    private final CashierId cashierId;

    public CashierAssigned(AttractionId attractionId, CashierId cashierId) {
        super("corparques.sofka.cashierassigned");
        this.attractionId = attractionId;
        this.cashierId = cashierId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
