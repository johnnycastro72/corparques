package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.restaurant.values.WaiterId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.Command;

public class UpdateWaiterEmail extends Command {
    private final WaiterId waiterId;
    private final Email email;

    public UpdateWaiterEmail(WaiterId waiterId, Email email) {
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
