package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.Height;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerHeightUpdated extends DomainEvent {
    private final CustomerId customerId;
    private final Height height;

    public AttractionCustomerHeightUpdated(CustomerId customerId, Height height) {
        super("corparques.sofka.attractioncustomerheightupdated");
        this.customerId = customerId;
        this.height = height;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Height height() {
        return height;
    }
}
