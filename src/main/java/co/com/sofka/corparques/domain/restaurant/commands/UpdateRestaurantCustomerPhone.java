package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.Command;

public class UpdateRestaurantCustomerPhone extends Command {
    private final RestaurantId restaurantId;
    private final CustomerId customerId;
    private final Phone phone;

    public UpdateRestaurantCustomerPhone(RestaurantId restaurantId, CustomerId customerId, Phone phone) {
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.phone = phone;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
