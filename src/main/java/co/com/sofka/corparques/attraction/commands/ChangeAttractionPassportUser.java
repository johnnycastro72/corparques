package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.IsPassportUser;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.Command;

public class ChangeAttractionPassportUser extends Command {
    private final CustomerId customerId;
    private final IsPassportUser isPassportUser;

    public ChangeAttractionPassportUser(CustomerId customerId, IsPassportUser isPassportUser) {
        this.customerId = customerId;
        this.isPassportUser = isPassportUser;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public IsPassportUser isPassportUser() {
        return isPassportUser;
    }
}
