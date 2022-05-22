package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class WaiterAdded extends DomainEvent {
    private final WaiterId waiterId;
    private final Name name;
    private final Email email;
    private final Phone phone;

    public WaiterAdded(WaiterId waiterId, Name name, Email email, Phone phone) {
        super("corparques.sofka.waiteradded");
        this.waiterId = waiterId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Phone phone() {
        return phone;
    }
}
