package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterEmailUpdated extends DomainEvent {
    private final WaiterId waiterId;
    private final Email email;

    public WaiterEmailUpdated(WaiterId waiterId, Email email) {
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
