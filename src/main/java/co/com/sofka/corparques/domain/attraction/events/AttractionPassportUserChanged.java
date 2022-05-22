package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.IsPassportUser;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionPassportUserChanged extends DomainEvent {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final IsPassportUser isPassportUser;

    public AttractionPassportUserChanged(AttractionId attractionId, CustomerId customerId, IsPassportUser isPassportUser) {
        super("corparques.sofka.attractionpassportuserchanged");
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.isPassportUser = isPassportUser;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public IsPassportUser isPassportUser() {
        return isPassportUser;
    }
}
