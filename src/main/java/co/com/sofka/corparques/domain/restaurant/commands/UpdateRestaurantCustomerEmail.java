package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.Command;

public class UpdateRestaurantCustomerEmail extends Command {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;
    private final Email email;

    public UpdateRestaurantCustomerEmail(RestaurantId restaurantId, CustomerId customerId, Email email) {
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.email = email;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Email email() {
        return email;
    }
}
