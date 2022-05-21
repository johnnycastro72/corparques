package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.AttractionId;
import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorAssigned extends DomainEvent {
    public OperatorAssigned(OperatorId operatorId) {
        super("corparques.sofka.operatorassigned");
    }
}
