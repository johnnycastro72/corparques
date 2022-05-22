package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.generic.values.Message;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.domain.generic.DomainEvent;

public class LogisticsByRestaurantNotified extends DomainEvent {
    private final RestaurantId restaurantId;
    private final Message message;

    public LogisticsByRestaurantNotified(RestaurantId restaurantId, Message message) {
        super("corparques.sofka.logisticsbyrestaurantnotified");
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
