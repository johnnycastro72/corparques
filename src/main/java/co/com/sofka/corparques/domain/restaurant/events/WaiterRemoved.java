package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterRemoved extends DomainEvent {
    private final RestaurantId restaurantId;
    private final WaiterId waiterId;

    public WaiterRemoved(RestaurantId restaurantId, WaiterId waiterId) {
        super("corparques.sofka.waiterremoved");
        this.restaurantId = restaurantId;
        this.waiterId = waiterId;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }
}
