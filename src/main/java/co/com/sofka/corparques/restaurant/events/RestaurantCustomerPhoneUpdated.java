package co.com.sofka.corparques.restaurant.events;

import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.DomainEvent;

public class RestaurantCustomerPhoneUpdated extends DomainEvent {
    private final CustomerId customerId;
    private final Phone phone;

    public RestaurantCustomerPhoneUpdated(CustomerId customerId, Phone phone) {
        super("corparques.sofka.restaurantcustomerphoneupdated");
        this.customerId = customerId;
        this.phone = phone;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public Phone phone() {
        return phone;
    }
}
