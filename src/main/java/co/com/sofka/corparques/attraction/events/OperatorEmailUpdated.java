package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorEmailUpdated extends DomainEvent {
    private final OperatorId operatorId;
    private final Email email;

    public OperatorEmailUpdated(OperatorId operatorId, Email email) {
        super("corparques.sofka.operatoremailupdated");
        this.operatorId = operatorId;
        this.email = email;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Email email() {
        return email;
    }
}
