package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;

public class UpdateAttractionCustomerEmail {
    private final CustomerId customerId;
    private final Email email;

    public UpdateAttractionCustomerEmail(CustomerId customerId, Email email) {
        this.customerId = customerId;
        this.email = email;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Email email() {
        return email;
    }
}
