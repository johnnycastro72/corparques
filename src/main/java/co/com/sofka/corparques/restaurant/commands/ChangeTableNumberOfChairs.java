package co.com.sofka.corparques.restaurant.commands;

import co.com.sofka.corparques.restaurant.values.NumberOfChairs;
import co.com.sofka.corparques.restaurant.values.TableId;
import co.com.sofka.domain.generic.Command;

public class ChangeTableNumberOfChairs extends Command {
    private final TableId tableId;
    private final NumberOfChairs numberOfChairs;

    public ChangeTableNumberOfChairs(TableId tableId, NumberOfChairs numberOfChairs) {
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
