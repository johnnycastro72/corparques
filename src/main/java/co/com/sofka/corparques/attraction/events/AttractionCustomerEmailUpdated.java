package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
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
