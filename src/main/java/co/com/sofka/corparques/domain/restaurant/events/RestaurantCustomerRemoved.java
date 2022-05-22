package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerRemoved extends DomainEvent {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;

    public RestaurantCustomerRemoved(RestaurantId restaurantId, CustomerId customerId) {
        super("corparques.sofka.restaurantcustomerremoved");
        this.restaurantId = restaurantId;
        this.customerId = customerId;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }
}
