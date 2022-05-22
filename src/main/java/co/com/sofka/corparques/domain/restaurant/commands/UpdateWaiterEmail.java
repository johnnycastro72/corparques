package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.WaiterId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.Command;

public class UpdateWaiterEmail extends Command {
    private final RestaurantId restaurantId;
    private final WaiterId waiterId;
    private final Email email;

    public UpdateWaiterEmail(RestaurantId restaurantId, WaiterId waiterId, Email email) {
        this.restaurantId = restaurantId;
        this.waiterId = waiterId;
        this.email = email;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public WaiterId waiterId() {
        return waiterId;
    }

    public Email email() {
        return email;
    }
}
