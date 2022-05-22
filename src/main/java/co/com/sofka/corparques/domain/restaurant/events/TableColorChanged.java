package co.com.sofka.corparques.domain.restaurant.events;

import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.corparques.domain.restaurant.values.Color;
import co.com.sofka.domain.generic.DomainEvent;

public class TableColorChanged extends DomainEvent {
    private final TableId tableId;
    private final Color color;

    public TableColorChanged(TableId tableId, Color color) {
        super("corparques.sofka.tablecolorchanged");
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
