package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.restaurant.values.Location;
import co.com.sofka.corparques.restaurant.values.RestaurantId;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.domain.generic.Command;

public class CreateRestaurant extends Command {
    private final RestaurantId restaurantId;
    private final Name name;
    private final Location location;

    public CreateRestaurant(RestaurantId restaurantId, Name name, Location location) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public Name name() {
        return name;
    }

    public Location location() {
        return location;
    }
}
