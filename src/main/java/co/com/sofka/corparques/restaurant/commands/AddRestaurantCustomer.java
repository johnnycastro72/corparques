package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Command;

public class AddRestaurantCustomer extends Command {
    private final CustomerId customerId;
    private final Name name;
    private final Email email;
    private final Phone phone;

    public AddRestaurantCustomer(CustomerId customerId, Name name, Email email, Phone phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
}
