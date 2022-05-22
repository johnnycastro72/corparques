package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterRemoved extends DomainEvent {
    private final WaiterId waiterId;

    public WaiterRemoved(WaiterId waiterId) {
        super("corparques.sofka.waiterremoved");
        this.waiterId = waiterId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }
}
