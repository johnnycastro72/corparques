package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerPhoneUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final Phone phone;

    public AttractionCustomerPhoneUpdated(AttractionId attractionId, CustomerId customerId, Phone phone) {
        super("corparques.sofka.attractioncustomerphoneupdated");
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
