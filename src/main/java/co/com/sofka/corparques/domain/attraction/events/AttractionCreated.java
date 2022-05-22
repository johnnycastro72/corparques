package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCreated extends DomainEvent {
    private final AttractionId attractionId;
    private final Name name;
    private final Capacity capacity;
    private final MinimumHeight minimumHeight;
    private final OperatorId operatorId;
    private final CashierId cashierId;

    public AttractionCreated(AttractionId attractionId, Name name, Capacity capacity, MinimumHeight minimumHeight, OperatorId operatorId, CashierId cashierId) {
        super("corparques.sofka.attractioncreated");
        this.attractionId = attractionId;
        this.name = name;
        this.capacity = capacity;
        this.minimumHeight = minimumHeight;
        this.operatorId = operatorId;
        this.cashierId = cashierId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public Name name() {
        return name;
    }

    public Capacity capacity() {
        return capacity;
    }

    public MinimumHeight minimumHeight() {
        return minimumHeight;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
