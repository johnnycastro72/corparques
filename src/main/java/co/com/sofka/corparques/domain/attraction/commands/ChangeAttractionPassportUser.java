package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.IsPassportUser;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.Command;

public class ChangeAttractionPassportUser extends Command {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final IsPassportUser isPassportUser;

    public ChangeAttractionPassportUser(AttractionId attractionId, CustomerId customerId, IsPassportUser isPassportUser) {
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.isPassportUser = isPassportUser;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public IsPassportUser isPassportUser() {
        return isPassportUser;
    }
}
