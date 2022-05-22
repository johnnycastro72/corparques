package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.domain.generic.DomainEvent;

public class TableRemoved extends DomainEvent {
    private final RestaurantId restaurantId;
    private final TableId tableId;

    public TableRemoved(RestaurantId restaurantId, TableId tableId) {
        super("corparques.sofka.tableremoved");
        this.restaurantId = restaurantId;
        this.tableId = tableId;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public TableId tableId() {
        return tableId;
    }
}
