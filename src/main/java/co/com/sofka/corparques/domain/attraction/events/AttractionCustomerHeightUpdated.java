package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.Height;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerHeightUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final Height height;

    public AttractionCustomerHeightUpdated(AttractionId attractionId, CustomerId customerId, Height height) {
        super("corparques.sofka.attractioncustomerheightupdated");
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.height = height;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Height height() {
        return height;
    }
}
