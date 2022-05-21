package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.BirthDate;
import co.com.sofka.corparques.attraction.values.Height;
import co.com.sofka.corparques.attraction.values.IsPassportUser;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerAdded extends DomainEvent {
    public AttractionCustomerAdded(CustomerId customerId, Name name, Email email, Phone phone, BirthDate birthDate, Height height, IsPassportUser isPassportUser) {
        super("corparques.sofka.attractioncustomeradded");
    }
}
