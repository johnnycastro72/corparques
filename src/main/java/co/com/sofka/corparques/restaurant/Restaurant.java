package co.com.sofka.corparques.restaurant;

import co.com.sofka.corparques.attraction.AttractionCustomer;
import co.com.sofka.corparques.restaurant.events.RestaurantCreated;
import co.com.sofka.corparques.restaurant.values.Location;
import co.com.sofka.corparques.restaurant.values.RestaurantId;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Restaurant extends AggregateEvent<RestaurantId> {
    protected Name name;
    protected Location location;
    protected Set<RestaurantCustomer> customers;
    protected Set<Waiter> waiters;
    protected Set<Table> tables;


    private Restaurant(RestaurantId restaurantId) {
        super(restaurantId);
        subscribe(new RestaurantChange(this));
    }

    public Restaurant(RestaurantId restaurantId, Name name, Location location) {
        super(restaurantId);
        appendChange(new RestaurantCreated(restaurantId, name, location)).apply();
    }

    public static Restaurant from(RestaurantId restaurantId, List<DomainEvent> events) {
        var restaurant = new Restaurant(restaurantId);
        events.forEach(restaurant::applyEvent);
        return restaurant;
    }



    public Name name() {
        return name;
    }

    public Location location() {
        return location;
    }

    public Set<RestaurantCustomer> customers() {
        return customers;
    }

    public Set<Waiter> waiters() {
        return waiters;
    }

    public Set<Table> tables() {
        return tables;
    }
}
