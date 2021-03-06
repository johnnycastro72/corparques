package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.domain.generic.Command;

public class RemoveTable extends Command {
    private final RestaurantId restaurantId;
    private final TableId tableId;

    public RemoveTable(RestaurantId restaurantId, TableId tableId) {
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
