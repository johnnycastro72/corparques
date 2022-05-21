package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateRestaurantCustomerPhone extends Command {
    private final CustomerId customerId;
    private final Phone phone;

    public UpdateRestaurantCustomerPhone(CustomerId customerId, Phone phone) {
        this.customerId = customerId;
        this.phone = phone;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
