package co.com.sofka.corparques.restaurant;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class RestaurantCustomer extends Entity<CustomerId> {
    private Name name;
    private Email email;
    private Phone phone;

    public RestaurantCustomer(CustomerId customerId) {
        super(customerId);
    }

    public RestaurantCustomer(CustomerId customerId, Name name, Email email, Phone phone) {
        super(customerId);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void UpdatePhone(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public void UpdateEmail(Email email) {
        this.email = Objects.requireNonNull(email);
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
}
