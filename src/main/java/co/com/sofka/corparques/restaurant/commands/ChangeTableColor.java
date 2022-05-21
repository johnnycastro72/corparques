package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.restaurant.values.Color;
import co.com.sofka.corparques.restaurant.values.TableId;
import co.com.sofka.domain.generic.Command;

public class ChangeTableColor extends Command {
    private final TableId tableId;
    private final Color color;

    public ChangeTableColor(TableId tableId, Color color) {
        this.tableId = tableId;
        this.color = color;
    }

    public TableId tableId() {
        return tableId;
    }

    public Color color() {
        return color;
    }
}
