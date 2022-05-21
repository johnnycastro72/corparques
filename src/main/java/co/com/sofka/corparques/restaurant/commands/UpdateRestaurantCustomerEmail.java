package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
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
