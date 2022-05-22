package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateAttractionCustomerPhone extends Command {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final Phone phone;

    public UpdateAttractionCustomerPhone(AttractionId attractionId, CustomerId customerId, Phone phone) {
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
