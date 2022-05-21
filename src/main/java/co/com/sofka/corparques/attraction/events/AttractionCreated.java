package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.*;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCreated extends DomainEvent {
    public AttractionCreated(AttractionId attractionId, Name name, Capacity capacity, MinimumHeight minimumHeight, OperatorId operatorId, CashierId cashierId) {
        super("corparques.sofka.attractioncreated");
    }
}
