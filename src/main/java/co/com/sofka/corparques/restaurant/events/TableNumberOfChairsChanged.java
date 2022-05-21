package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.restaurant.values.NumberOfChairs;
import co.com.sofka.corparques.restaurant.values.TableId;
import co.com.sofka.domain.generic.DomainEvent;

public class TableNumberOfChairsChanged extends DomainEvent {
    private final TableId tableId;
    private final NumberOfChairs numberOfChairs;

    public TableNumberOfChairsChanged(TableId tableId, NumberOfChairs numberOfChairs) {
        super("corparques.sofka.tablenumberofchairschanged");
        this.tableId = tableId;
        this.numberOfChairs = numberOfChairs;
    }

    public TableId tableId() {
        return tableId;
    }

    public NumberOfChairs numberOfChairs() {
        return numberOfChairs;
    }
}
