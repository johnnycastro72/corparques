package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.Color;
import co.com.sofka.domain.generic.Command;

public class ChangeTableColor extends Command {
    private final RestaurantId restaurantId;
    private final TableId tableId;
    private final Color color;

    public ChangeTableColor(RestaurantId restaurantId, TableId tableId, Color color) {
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
