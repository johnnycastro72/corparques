package co.com.sofka.corparques.domain.restaurant.commands;

import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.domain.generic.Command;

public class RemoveTable extends Command {
    private final TableId tableId;

    public RemoveTable(TableId tableId) {
        this.tableId = tableId;
    }

    public TableId tableId() {
        return tableId;
    }
}
