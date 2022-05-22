package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.generic.values.Message;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.Command;

public class RestaurantNotifyLogistics extends Command {
    private final RestaurantId restaurantId;
    private final Message message;

    public RestaurantNotifyLogistics(RestaurantId restaurantId, Message message) {
        this.restaurantId = restaurantId;
        this.message = message;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public Message message() {
        return message;
    }
}
