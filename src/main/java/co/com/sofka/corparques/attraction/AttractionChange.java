package co.com.sofka.corparques.attraction;

import co.com.sofka.corparques.attraction.events.*;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class AttractionChange extends EventChange {
    public AttractionChange(Attraction attraction) {

        apply((AttractionCreated event) -> {
            attraction.name = event.name();
            attraction.capacity = event.capacity();
            attraction.minimumHeight = event.minimumHeight();
            attraction.operatorId = event.operatorId();
            attraction.cashierId = event.cashierId();
            attraction.customers = new HashSet<>();
        });

        apply((AttractionCustomerAdded event) -> {
            Integer customersSize = attraction.customers().size();
            if (customersSize.equals(attraction.capacity.value())) {
                throw new IllegalArgumentException("The attraction has reached its maximum capacity " + attraction.capacity.toString() + " and cannot add more customers.");
            }
            attraction.customers.add(new AttractionCustomer(
                    event.customerId(),
                    event.name(),
                    event.email(),
                    event.phone(),
                    event.birthDate(),
                    event.height(),
                    event.isPassportUser()
            ));
        });

        apply((AttractionCustomerEmailUpdated event) -> {
            var customer = new AttractionCustomer(event.customerId());
            customer.UpdateEmail(event.email());
        });

        apply((AttractionCustomerHeightUpdated event) -> {
            var customer = new AttractionCustomer(event.customerId());
            customer.UpdateHeight(event.height());
        });

        apply((AttractionCustomerPhoneUpdated event) -> {
            var customer = new AttractionCustomer(event.customerId());
            customer.UpdatePhone(event.phone());
        });

        apply((AttractionPassportUserChanged event) -> {
            var customer = new AttractionCustomer(event.customerId());
            customer.ChangePassportUser(event.isPassportUser());
        });

        apply((CapacityUpdated event) -> {
            attraction.capacity = event.capacity();
        });

        apply((CashierAssigned event) -> {
            attraction.cashierId = event.cashierId();
        });

        apply((CashierEmailUpdated event) -> {
            var cashier = new Cashier(event.cashierId());
            cashier.UpdateEmail(event.email());
        });

        apply((CashierPhoneUpdated event) -> {
            var cashier = new Cashier(event.cashierId());
            cashier.UpdatePhone(event.phone());
        });

        apply((OperatorAssigned event) -> {
            attraction.operatorId = event.operatorId();
        });

        apply((OperatorClothesChanged event) -> {
            var operator = new Operator(event.operatorId());
            operator.ChangeClothes(event.clothes());
        });

        apply((OperatorEmailUpdated event) -> {
            var operator = new Operator(event.operatorId());
            operator.UpdateEmail(event.email());
        });

        apply((OperatorPhoneUpdated event) -> {
            var operator = new Operator(event.operatorId());
            operator.UpdatePhone(event.phone());
        });

    }
}
