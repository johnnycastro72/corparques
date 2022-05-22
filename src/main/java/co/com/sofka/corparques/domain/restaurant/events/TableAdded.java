package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.Color;
import co.com.sofka.corparques.domain.restaurant.values.NumberOfChairs;
import co.com.sofka.domain.generic.DomainEvent;

public class TableAdded extends DomainEvent {
    private final RestaurantId restaurantId;
    private final TableId tableId;
    private final Color color;
    private final NumberOfChairs numberOfChairs;

    public TableAdded(RestaurantId restaurantId, TableId tableId, Color color, NumberOfChairs numberOfChairs) {
        super("corparques.sofka.TableAdded");
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.color = color;
        this.numberOfChairs = numberOfChairs;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public TableId tableId() {
        return tableId;
    }

    public Color color() {
        return color;
    }

    public NumberOfChairs numberOfChairs() {
        return numberOfChairs;
    }
}
