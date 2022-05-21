package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerPhoneUpdated extends DomainEvent {
    private final CustomerId customerId;
    private final Phone phone;

    public AttractionCustomerPhoneUpdated(CustomerId customerId, Phone phone) {
        super("corparques.sofka.attractioncustomerphoneupdated");
        this.customerId = customerId;
        this.phone = phone;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
