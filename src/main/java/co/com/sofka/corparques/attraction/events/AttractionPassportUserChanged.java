package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.IsPassportUser;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionPassportUserChanged extends DomainEvent {
    public AttractionPassportUserChanged(CustomerId customerId, IsPassportUser isPassportUser) {
        super("corparques.sofka.attractionpassportuserchanged");
    }
}
