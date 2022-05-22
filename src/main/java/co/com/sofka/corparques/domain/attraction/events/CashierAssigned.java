package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.domain.generic.DomainEvent;

public class CashierAssigned extends DomainEvent {
    private final CashierId cashierId;

    public CashierAssigned(CashierId cashierId) {
        super("corparques.sofka.cashierassigned");
        this.cashierId = cashierId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
