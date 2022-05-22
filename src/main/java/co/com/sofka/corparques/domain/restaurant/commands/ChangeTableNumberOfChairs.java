package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.NumberOfChairs;
import co.com.sofka.domain.generic.Command;

public class ChangeTableNumberOfChairs extends Command {
    private final RestaurantId restaurantId;
    private final TableId tableId;
    private final NumberOfChairs numberOfChairs;

    public ChangeTableNumberOfChairs(RestaurantId restaurantId, TableId tableId, NumberOfChairs numberOfChairs) {
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
