package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerPhoneUpdated extends DomainEvent {
    public AttractionCustomerPhoneUpdated(CustomerId customerId, Phone phone) {
        super("corparques.sofka.attractioncustomerphoneupdated");
    }
}
