package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.domain.generic.Command;

public class RemoveWaiter extends Command {
    private final RestaurantId restaurantId;
    private final WaiterId waiterId;

    public RemoveWaiter(RestaurantId restaurantId, WaiterId waiterId) {
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
