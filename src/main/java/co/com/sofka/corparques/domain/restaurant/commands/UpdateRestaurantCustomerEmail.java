package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.Command;

public class UpdateRestaurantCustomerEmail extends Command {
    private final CustomerId customerId;
    private final Email email;

    public UpdateRestaurantCustomerEmail(CustomerId customerId, Email email) {
        this.customerId = customerId;
        this.email = email;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Email email() {
        return email;
    }
}
