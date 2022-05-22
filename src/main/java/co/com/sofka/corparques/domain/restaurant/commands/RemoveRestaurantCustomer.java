package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.Command;

public class RemoveRestaurantCustomer extends Command {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;

    public RemoveRestaurantCustomer(RestaurantId restaurantId, CustomerId customerId) {
        this.restaurantId = restaurantId;
        this.customerId = customerId;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }
}
