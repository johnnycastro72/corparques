package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.domain.generic.Command;

public class AssignOperator extends Command {
    private final AttractionId attractionId;
    private final OperatorId operatorId;

    public AssignOperator(AttractionId attractionId, OperatorId operatorId) {
        this.attractionId = attractionId;
        this.operatorId = operatorId;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }
}
