package co.com.sofka.corparques.domain.attraction;

import co.com.sofka.corparques.domain.attraction.values.BirthDate;
import co.com.sofka.corparques.domain.attraction.values.Height;
import co.com.sofka.corparques.domain.attraction.values.IsPassportUser;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class AttractionCustomer extends Entity<CustomerId> {
    private Name name;
    private Email email;
    private Phone phone;
    private BirthDate birthDate;
    private Height height;
    private IsPassportUser isPassportUser;

    public AttractionCustomer(CustomerId customerId) {
        super(customerId);
    }

    public AttractionCustomer(CustomerId customerId, Name name, Email email, Phone phone, BirthDate birthDate, Height height, IsPassportUser isPassportUser) {
        super(customerId);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.height = height;
        this.isPassportUser = isPassportUser;
    }

    public void UpdateHeight(Height height) {
        this.height = Objects.requireNonNull(height);
    }

    public void UpdateEmail(Email email) {
        this.email = Objects.requireNonNull(email);
    }

    public void UpdatePhone(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public void ChangePassportUser(IsPassportUser isPassportUser) {
        this.isPassportUser = isPassportUser;
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
