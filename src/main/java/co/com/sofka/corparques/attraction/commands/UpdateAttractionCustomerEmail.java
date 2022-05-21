package co.com.sofka.corparques.attraction.commands;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;

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
