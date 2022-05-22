package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerEmailUpdated extends DomainEvent {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;
    private final Email email;

    public RestaurantCustomerEmailUpdated(RestaurantId restaurantId, CustomerId customerId, Email email) {
        super("corparques.sofka.restaurantcustomeremailupdated");
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.email = email;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Email email() {
        return email;
    }
}
