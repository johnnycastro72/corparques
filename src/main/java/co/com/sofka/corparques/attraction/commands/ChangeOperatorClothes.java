package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.Clothes;
import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.domain.generic.Command;

public class ChangeOperatorClothes extends Command {
    private final OperatorId operatorId;
    private final Clothes clothes;

    public ChangeOperatorClothes(OperatorId operatorId, Clothes clothes) {
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
