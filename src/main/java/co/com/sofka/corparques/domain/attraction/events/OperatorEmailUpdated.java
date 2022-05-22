package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorEmailUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final OperatorId operatorId;
    private final Email email;

    public OperatorEmailUpdated(AttractionId attractionId, OperatorId operatorId, Email email) {
        super("corparques.sofka.operatoremailupdated");
        this.attractionId = attractionId;
        this.operatorId = operatorId;
        this.email = email;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Email email() {
        return email;
    }
}
