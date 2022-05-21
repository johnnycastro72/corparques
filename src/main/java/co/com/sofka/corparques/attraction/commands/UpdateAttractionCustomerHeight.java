package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.attraction.values.Height;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.Command;

public class UpdateAttractionCustomerHeight extends Command {
    private final CustomerId customerId;
    private final Height height;

    public UpdateAttractionCustomerHeight(CustomerId customerId, Height height) {
        this.customerId = customerId;
        this.height = height;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Height height() {
        return height;
    }
}
