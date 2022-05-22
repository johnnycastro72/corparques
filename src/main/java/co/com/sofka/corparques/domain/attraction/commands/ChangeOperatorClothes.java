package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.Clothes;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.domain.generic.Command;

public class ChangeOperatorClothes extends Command {
    private final AttractionId attractionId;
    private final OperatorId operatorId;
    private final Clothes clothes;

    public ChangeOperatorClothes(AttractionId attractionId, OperatorId operatorId, Clothes clothes) {
        this.attractionId = attractionId;
        this.operatorId = operatorId;
        this.clothes = clothes;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Clothes clothes() {
        return clothes;
    }
}
