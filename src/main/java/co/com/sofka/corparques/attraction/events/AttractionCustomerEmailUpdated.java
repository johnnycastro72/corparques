package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerEmailUpdated extends DomainEvent {
    public AttractionCustomerEmailUpdated(CustomerId customerId, Email email) {
        super("corparques.sofka.attractioncustomeremailupdated");
    }
}
