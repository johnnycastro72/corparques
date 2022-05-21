package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.Clothes;
import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.domain.generic.DomainEvent;

public class OperatorClothesChanged extends DomainEvent {
    public OperatorClothesChanged(OperatorId operatorId, Clothes clothes) {
        super("corparques.sofka.operatorclotheschanged");
    }
}
