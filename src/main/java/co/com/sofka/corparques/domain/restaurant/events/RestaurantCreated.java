package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.Location;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCreated extends DomainEvent {
    private final Name name;
    private final Location location;

    public RestaurantCreated(RestaurantId restaurantId, Name name, Location location) {
        super("corparques.sofka.restaurantcreated");
        this.name = name;
        this.location = location;
    }

    public Name name() {
        return name;
    }

    public Location location() {
        return location;
    }
}
