package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.Command;

public class RemoveRestaurantCustomer extends Command {
    private final CustomerId customerId;

    public RemoveRestaurantCustomer(CustomerId customerId) {
        this.customerId = customerId;
    }

    public CustomerId customerId() {
        return customerId;
    }
}
