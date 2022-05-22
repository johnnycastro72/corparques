package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.domain.generic.Command;

public class AssignCashier extends Command {
    private final AttractionId attractionId;
    private final CashierId cashierId;

    public AssignCashier(AttractionId attractionId, CashierId cashierId) {
        this.attractionId = attractionId;
        this.cashierId = cashierId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
