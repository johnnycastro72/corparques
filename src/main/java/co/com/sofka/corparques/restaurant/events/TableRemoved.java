package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.restaurant.values.TableId;
import co.com.sofka.domain.generic.DomainEvent;

public class TableRemoved extends DomainEvent {
    private final TableId tableId;

    public TableRemoved(TableId tableId) {
        super("corparques.sofka.tableremoved");
        this.tableId = tableId;
    }

    public TableId tableId() {
        return tableId;
    }
}
