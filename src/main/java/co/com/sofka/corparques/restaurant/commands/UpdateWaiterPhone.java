package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.restaurant.values.WaiterId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateWaiterPhone extends Command {
    private final WaiterId waiterId;
    private final Phone phone;

    public UpdateWaiterPhone(WaiterId waiterId, Phone phone) {
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
