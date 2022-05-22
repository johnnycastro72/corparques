package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorPhoneUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final OperatorId operatorId;
    private final Phone phone;

    public OperatorPhoneUpdated(AttractionId attractionId, OperatorId operatorId, Phone phone) {
        super("corparques.sofka.operatorphoneupdated");
        this.attractionId = attractionId;
        this.operatorId = operatorId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Phone phone() {
        return phone;
    }
}
