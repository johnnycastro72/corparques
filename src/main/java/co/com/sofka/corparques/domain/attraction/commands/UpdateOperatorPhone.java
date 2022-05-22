package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateOperatorPhone extends Command {
    private final AttractionId attractionId;
    private final OperatorId operatorId;
    private final Phone phone;

    public UpdateOperatorPhone(AttractionId attractionId, OperatorId operatorId, Phone phone) {
        this.attractionId = attractionId;
        this.operatorId = operatorId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public Phone phone() {
        return phone;
    }
}
