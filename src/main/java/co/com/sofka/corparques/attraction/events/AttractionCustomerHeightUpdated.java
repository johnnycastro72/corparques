package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.Height;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerHeightUpdated extends DomainEvent {
    public AttractionCustomerHeightUpdated(CustomerId customerId, Height height) {
        super("corparques.sofka.attractioncustomerheightupdated");
    }
}
