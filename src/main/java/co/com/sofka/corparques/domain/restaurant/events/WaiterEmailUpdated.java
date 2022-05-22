package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterEmailUpdated extends DomainEvent {
    private final RestaurantId restaurantId;
    private final WaiterId waiterId;
    private final Email email;

    public WaiterEmailUpdated(RestaurantId restaurantId, WaiterId waiterId, Email email) {
        super("corparques.sofka.restaurantwaiteremailupdated");
        this.restaurantId = restaurantId;
        this.waiterId = waiterId;
        this.email = email;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Email email() {
        return email;
    }
}
