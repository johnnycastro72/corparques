package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.IsPassportUser;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionPassportUserChanged extends DomainEvent {
    private final CustomerId customerId;
    private final IsPassportUser isPassportUser;

    public AttractionPassportUserChanged(CustomerId customerId, IsPassportUser isPassportUser) {
        super("corparques.sofka.attractionpassportuserchanged");
        this.customerId = customerId;
        this.isPassportUser = isPassportUser;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public IsPassportUser isPassportUser() {
        return isPassportUser;
    }
}
