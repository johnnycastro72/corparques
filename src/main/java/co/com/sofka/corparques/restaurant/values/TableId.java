package co.com.sofka.corparques.restaurant.values;

import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.domain.generic.Identity;

public class TableId extends Identity {
    public TableId() {
    }

    private TableId(String id) {
        super(id);
    }

    public static TableId of(String id) {
        return new TableId(id);
    }
}
