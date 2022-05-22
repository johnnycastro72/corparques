package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerRemoved extends DomainEvent {
    private final CustomerId customerId;

    public RestaurantCustomerRemoved(CustomerId customerId) {
        super("corparques.sofka.restaurantcustomerremoved");
        this.customerId = customerId;
    }

    public CustomerId customerId() {
        return customerId;
    }
}
