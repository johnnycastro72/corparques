package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.domain.generic.Command;

public class RemoveWaiter extends Command {
    private final WaiterId waiterId;

    public RemoveWaiter(WaiterId waiterId) {
        this.waiterId = waiterId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }
}
