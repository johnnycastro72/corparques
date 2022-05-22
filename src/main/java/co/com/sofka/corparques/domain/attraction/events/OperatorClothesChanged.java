package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.Clothes;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorClothesChanged extends DomainEvent {
    private final OperatorId operatorId;
    private final Clothes clothes;

    public OperatorClothesChanged(OperatorId operatorId, Clothes clothes) {
        super("corparques.sofka.operatorclotheschanged");
        this.operatorId = operatorId;
        this.clothes = clothes;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Clothes clothes() {
        return clothes;
    }
}
