package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.restaurant.values.WaiterId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantWaiterEmailUpdated extends DomainEvent {
    private final WaiterId waiterId;
    private final Email email;

    public RestaurantWaiterEmailUpdated(WaiterId waiterId, Email email) {
        super("corparques.sofka.restaurantwaiteremailupdated");
        this.waiterId = waiterId;
        this.email = email;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Email email() {
        return email;
    }
}
