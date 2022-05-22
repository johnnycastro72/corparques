package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.Height;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.domain.generic.Command;

public class UpdateAttractionCustomerHeight extends Command {
    private final AttractionId attractionId;
    private final CustomerId customerId;
    private final Height height;

    public UpdateAttractionCustomerHeight(AttractionId attractionId, CustomerId customerId, Height height) {
        this.attractionId = attractionId;
        this.customerId = customerId;
        this.height = height;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Height height() {
        return height;
    }
}
