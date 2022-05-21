package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerEmailUpdated extends DomainEvent {
    private final CustomerId customerId;
    private final Email email;

    public RestaurantCustomerEmailUpdated(CustomerId customerId, Email email) {
        super("corparques.sofka.restaurantcustomeremailupdated");
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
