package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorEmailUpdated extends DomainEvent {
    public OperatorEmailUpdated(OperatorId operatorId, Email email) {
        super("corparques.sofka.operatoremailupdated");
    }
}
