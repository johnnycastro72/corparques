package co.com.sofka.corparques.domain.restaurant;

import co.com.sofka.corparques.domain.generic.values.*;
import co.com.sofka.corparques.domain.restaurant.events.*;
import co.com.sofka.corparques.domain.restaurant.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Restaurant extends AggregateEvent<RestaurantId> {
    protected Name name;
    protected Location location;
    protected Set<RestaurantCustomer> customers;
    protected Set<Waiter> waiters;
    protected Set<Table> tables;


    private Restaurant(RestaurantId restaurantId) {
        super(restaurantId);
        subscribe(new RestaurantChange(this));
    }

    public Restaurant(RestaurantId restaurantId, Name name, Location location) {
        super(restaurantId);
        appendChange(new RestaurantCreated(restaurantId, name, location)).apply();
    }

    public static Restaurant from(RestaurantId restaurantId, List<DomainEvent> events) {
        var restaurant = new Restaurant(restaurantId);
        events.forEach(restaurant::applyEvent);
        return restaurant;
    }

    public void AddRestaurantCustomer(RestaurantId restaurantId, CustomerId customerId, Name name, Email email, Phone phone) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        appendChange(new RestaurantCustomerAdded(restaurantId, customerId, name, email, phone)).apply();
    }

    public void RemoveRestaurantCustomer(RestaurantId restaurantId, CustomerId customerId) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(customerId);
        appendChange(new RestaurantCustomerRemoved(restaurantId, customerId)).apply();
    }

    public void AddWaiter(RestaurantId restaurantId, WaiterId waiterId, Name name, Email email, Phone phone) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        appendChange(new WaiterAdded(restaurantId, waiterId, name, email, phone)).apply();
    }

    public void RemoveWaiter(RestaurantId restaurantId, WaiterId waiterId) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(waiterId);
        appendChange(new WaiterRemoved(restaurantId, waiterId)).apply();
    }

    public void AddTable(RestaurantId restaurantId, TableId tableId, Color color, NumberOfChairs numberOfChairs) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(color);
        Objects.requireNonNull(numberOfChairs);
        appendChange(new TableAdded(restaurantId, tableId, color, numberOfChairs)).apply();
    }

    public void RemoveTable(RestaurantId restaurantId, TableId tableId) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(tableId);
        appendChange(new TableRemoved(restaurantId, tableId)).apply();
    }

    public void UpdateRestaurantCustomerPhone(RestaurantId restaurantId, CustomerId customerId, Phone phone) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(phone);
        appendChange(new RestaurantCustomerPhoneUpdated(restaurantId, customerId, phone)).apply();
    }

    public void UpdateRestaurantCustomerEmail(RestaurantId restaurantId, CustomerId customerId, Email email) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(email);
        appendChange(new RestaurantCustomerEmailUpdated(restaurantId, customerId, email)).apply();
    }

    public void UpdateWaiterPhone(RestaurantId restaurantId, WaiterId waiterId, Phone phone) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(phone);
        appendChange(new WaiterPhoneUpdated(restaurantId, waiterId, phone)).apply();
    }

    public void UpdateWaiterEmail(RestaurantId restaurantId, WaiterId waiterId, Email email) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(email);
        appendChange(new WaiterEmailUpdated(restaurantId, waiterId, email)).apply();
    }

    public void ChangeTableColor(RestaurantId restaurantId, TableId tableId, Color color) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(color);
        appendChange(new TableColorChanged(restaurantId, tableId, color)).apply();
    }

    public void ChangeTableNumberOfChairs(RestaurantId restaurantId, TableId tableId, NumberOfChairs numberOfChairs) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(numberOfChairs);
        appendChange(new TableNumberOfChairsChanged(restaurantId, tableId, numberOfChairs)).apply();
    }

    public void RestaurantNotifyLogistics(RestaurantId restaurantId, Message message) {
        Objects.requireNonNull(restaurantId);
        Objects.requireNonNull(message);
        appendChange(new LogisticsByRestaurantNotified(restaurantId, message)).apply();
    }

    protected Optional<RestaurantCustomer> getRestaurantCustomerById(CustomerId customerId) {
        return customers()
                .stream()
                .filter(customer -> customer.identity().equals(customerId))
                .findFirst();
    }

    protected Optional<Waiter> getWaiterById(WaiterId waiterId) {
        return waiters()
                .stream()
                .filter(waiter -> waiter.identity().equals(waiterId))
                .findFirst();
    }

    protected Optional<Table> getTableById(TableId tableId) {
        return tables()
                .stream()
                .filter(table -> table.identity().equals(tableId))
                .findFirst();
    }

    public Name name() {
        return name;
    }

    public Location location() {
        return location;
    }

    public Set<RestaurantCustomer> customers() {
        return customers;
    }

    public Set<Waiter> waiters() {
        return waiters;
    }

    public Set<Table> tables() {
        return tables;
    }
}
