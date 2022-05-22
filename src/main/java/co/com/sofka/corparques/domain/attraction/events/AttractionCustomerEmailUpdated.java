package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerEmailUpdated extends DomainEvent {
    private final CustomerId customerId;
    private final Email email;

    public AttractionCustomerEmailUpdated(CustomerId customerId, Email email) {
        super("corparques.sofka.attractioncustomeremailupdated");
        this.customerId = customerId;
        this.email = email;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Email email() {
        return email;
    }
}
