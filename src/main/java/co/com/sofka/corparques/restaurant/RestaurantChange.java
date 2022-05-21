package co.com.sofka.corparques.restaurant;

import co.com.sofka.corparques.restaurant.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RestaurantChange extends EventChange {
    public RestaurantChange(Restaurant restaurant) {

        apply((RestaurantCreated event) -> {
            restaurant.name = event.name();
            restaurant.location = event.location();
            restaurant.customers = new HashSet<>();
            restaurant.tables = new HashSet<>();
            restaurant.waiters = new HashSet<>();
        });

        apply((RestaurantCustomerAdded event) -> {
            restaurant.customers.add(new RestaurantCustomer(
                    event.customerId(),
                    event.name(),
                    event.email(),
                    event.phone()
            ));
        });

        apply((RestaurantCustomerRemoved event) -> {
            restaurant.customers.remove(new RestaurantCustomer(event.customerId()));
        });

        apply((WaiterAdded event) -> {
            restaurant.waiters.add(new Waiter(
                    event.waiterId(),
                    event.name(),
                    event.email(),
                    event.phone()
            ));
        });

        apply((WaiterRemoved event) -> {
            restaurant.waiters.remove(new Waiter(event.waiterId()));
        });

        apply((TableAdded event) -> {
            restaurant.tables.add(new Table(event.tableId(), event.color(), event.numberOfChairs()));
        });

        apply((TableRemoved event) -> {
            restaurant.tables.remove(new Table(event.tableId()));
        });

        apply((RestaurantCustomerPhoneUpdated event) -> {
            var restaurantCustomer = new RestaurantCustomer(event.customerId());
            restaurantCustomer.UpdatePhone(event.phone());
        });

        apply((RestaurantCustomerEmailUpdated event) -> {
            var restaurantCustomer = new RestaurantCustomer(event.customerId());
            restaurantCustomer.UpdateEmail(event.email());
        });

        apply((WaiterPhoneUpdated event) -> {
            var waiter = new Waiter(event.waiterId());
            waiter.UpdatePhone(event.phone());
        });

        apply((WaiterEmailUpdated event) -> {
            var waiter = new Waiter(event.waiterId());
            waiter.UpdateEmail(event.email());
        });

        apply((TableColorChanged event) -> {
            var table = new Table(event.tableId());
            table.ChangeColor(event.color());
        });

        apply((TableNumberOfChairsChanged event) -> {
            var table = new Table(event.tableId());
            table.ChangeNumberOfChairs(event.numberOfChairs());
        });
    }
}
