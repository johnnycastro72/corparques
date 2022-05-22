package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterPhoneUpdated extends DomainEvent {
    private final RestaurantId restaurantId;
    private final WaiterId waiterId;
    private final Phone phone;

    public WaiterPhoneUpdated(RestaurantId restaurantId, WaiterId waiterId, Phone phone) {
        super("corparques.sofka.restaurantwaiterphoneupdated");
        this.restaurantId = restaurantId;
        this.waiterId = waiterId;
        this.phone = phone;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Phone phone() {
        return phone;
    }
}
