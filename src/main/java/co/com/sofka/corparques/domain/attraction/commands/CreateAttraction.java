package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.domain.generic.Command;

public class CreateAttraction extends Command {
    private final AttractionId attractionId;
    private final Name name;
    private final Capacity capacity;
    private final MinimumHeight minimumHeight;
    private final OperatorId operatorId;
    private final CashierId cashierId;

    public CreateAttraction(AttractionId attractionId, Name name, Capacity capacity, MinimumHeight minimumHeight, OperatorId operatorId, CashierId cashierId) {
        this.attractionId = attractionId;
        this.name = name;
        this.capacity = capacity;
        this.minimumHeight = minimumHeight;
        this.operatorId = operatorId;
        this.cashierId = cashierId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public Name name() {
        return name;
    }

    public Capacity capacity() {
        return capacity;
    }

    public MinimumHeight minimumHeight() {
        return minimumHeight;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public CashierId cashierId() {
        return cashierId;
    }
}
