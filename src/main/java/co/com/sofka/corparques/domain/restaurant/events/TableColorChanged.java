package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.Color;
import co.com.sofka.domain.generic.DomainEvent;

public class TableColorChanged extends DomainEvent {
    private final RestaurantId restaurantId;
    private final TableId tableId;
    private final Color color;

    public TableColorChanged(RestaurantId restaurantId, TableId tableId, Color color) {
        super("corparques.sofka.tablecolorchanged");
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.color = color;
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
}
