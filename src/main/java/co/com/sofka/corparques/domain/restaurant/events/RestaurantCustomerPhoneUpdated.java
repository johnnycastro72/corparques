package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerPhoneUpdated extends DomainEvent {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;
    private final Phone phone;

    public RestaurantCustomerPhoneUpdated(RestaurantId restaurantId, CustomerId customerId, Phone phone) {
        super("corparques.sofka.restaurantcustomerphoneupdated");
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.phone = phone;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
