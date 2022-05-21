package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.AttractionId;
import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierAssigned extends DomainEvent {
    public CashierAssigned(CashierId cashierId) {
        super("corparques.sofka.cashierassigned");
    }
}
