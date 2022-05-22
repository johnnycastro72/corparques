package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorAssigned extends DomainEvent {
    private final AttractionId attractionId;
    private final OperatorId operatorId;

    public OperatorAssigned(AttractionId attractionId, OperatorId operatorId) {
        super("corparques.sofka.operatorassigned");
        this.attractionId = attractionId;
        this.operatorId = operatorId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }
}
