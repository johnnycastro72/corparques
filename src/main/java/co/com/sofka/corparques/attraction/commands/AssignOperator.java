package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.domain.generic.Command;

public class AssignOperator extends Command {
    private final OperatorId operatorId;

    public AssignOperator(OperatorId operatorId) {
        this.operatorId = operatorId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }
}
