package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateOperatorPhone extends Command {
    private final OperatorId operatorId;
    private final Phone phone;

    public UpdateOperatorPhone(OperatorId operatorId, Phone phone) {
        this.operatorId = operatorId;
        this.phone = phone;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Phone phone() {
        return phone;
    }
}
