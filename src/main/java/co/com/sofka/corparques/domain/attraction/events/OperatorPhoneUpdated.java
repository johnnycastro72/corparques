package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorPhoneUpdated extends DomainEvent {
    private final OperatorId operatorId;
    private final Phone phone;

    public OperatorPhoneUpdated(OperatorId operatorId, Phone phone) {
        super("corparques.sofka.operatorphoneupdated");
        this.operatorId = operatorId;
        this.phone = phone;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Phone phone() {
        return phone;
    }
}
