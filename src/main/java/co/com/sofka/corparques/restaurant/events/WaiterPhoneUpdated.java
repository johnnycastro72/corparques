package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.restaurant.values.WaiterId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterPhoneUpdated extends DomainEvent {
    private final WaiterId waiterId;
    private final Phone phone;

    public WaiterPhoneUpdated(WaiterId waiterId, Phone phone) {
        super("corparques.sofka.restaurantwaiterphoneupdated");
        this.waiterId = waiterId;
        this.phone = phone;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Phone phone() {
        return phone;
    }
}
