package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.BirthDate;
import co.com.sofka.corparques.domain.attraction.values.Height;
import co.com.sofka.corparques.domain.attraction.values.IsPassportUser;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class AttractionCustomerAdded extends DomainEvent {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final Name name;
    private final Email email;
    private final Phone phone;
    private final BirthDate birthDate;
    private final Height height;
    private final IsPassportUser isPassportUser;

    public AttractionCustomerAdded(AttractionId attractionId, CustomerId customerId, Name name, Email email, Phone phone, BirthDate birthDate, Height height, IsPassportUser isPassportUser) {
        super("corparques.sofka.attractioncustomeradded");
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.height = height;
        this.isPassportUser = isPassportUser;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Phone phone() {
        return phone;
    }

    public BirthDate birthDate() {
        return birthDate;
    }

    public Height height() {
        return height;
    }

    public IsPassportUser isPassportUser() {
        return isPassportUser;
    }
}
