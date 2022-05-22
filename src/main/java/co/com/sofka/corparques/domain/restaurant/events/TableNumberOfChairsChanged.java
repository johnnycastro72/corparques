package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.NumberOfChairs;
import co.com.sofka.domain.generic.DomainEvent;

public class TableNumberOfChairsChanged extends DomainEvent {
    private final RestaurantId restaurantId;
    private final TableId tableId;
    private final NumberOfChairs numberOfChairs;

    public TableNumberOfChairsChanged(RestaurantId restaurantId, TableId tableId, NumberOfChairs numberOfChairs) {
        super("corparques.sofka.tablenumberofchairschanged");
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.numberOfChairs = numberOfChairs;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public TableId tableId() {
        return tableId;
    }

    public NumberOfChairs numberOfChairs() {
        return numberOfChairs;
    }
}
