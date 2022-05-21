package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.corparques.shared.Phone;
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
