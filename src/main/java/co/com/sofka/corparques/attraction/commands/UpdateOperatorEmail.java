package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.domain.generic.Command;

public class UpdateOperatorEmail extends Command {
    private final OperatorId operatorId;
    private final Email email;

    public UpdateOperatorEmail(OperatorId operatorId, Email email) {
        this.operatorId = operatorId;
        this.email = email;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Email email() {
        return email;
    }
}
