package co.com.sofka.corparques.domain.restaurant;

import co.com.sofka.corparques.domain.restaurant.events.*;
import co.com.sofka.corparques.domain.restaurant.values.*;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
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

    public void AddRestaurantCustomer(CustomerId customerId, Name name, Email email, Phone phone) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        appendChange(new RestaurantCustomerAdded(customerId, name, email, phone)).apply();
    }

    public void RemoveRestaurantCustomer(CustomerId customerId) {
        Objects.requireNonNull(customerId);
        appendChange(new RestaurantCustomerRemoved(customerId)).apply();
    }

    public void AddWaiter(WaiterId waiterId, Name name, Email email, Phone phone) {
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        appendChange(new WaiterAdded(waiterId, name, email, phone)).apply();
    }

    public void RemoveWaiter(WaiterId waiterId) {
        Objects.requireNonNull(waiterId);
        appendChange(new WaiterRemoved(waiterId)).apply();
    }

    public void AddTable(TableId tableId, Color color, NumberOfChairs numberOfChairs) {
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(color);
        Objects.requireNonNull(numberOfChairs);
        appendChange(new TableAdded(tableId, color, numberOfChairs)).apply();
    }

    public void RemoveTable(TableId tableId) {
        Objects.requireNonNull(tableId);
        appendChange(new TableRemoved(tableId)).apply();
    }

    public void UpdateRestaurantCustomerPhone(CustomerId customerId, Phone phone) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(phone);
        appendChange(new RestaurantCustomerPhoneUpdated(customerId, phone)).apply();
    }

    public void UpdateRestaurantCustomerEmail(CustomerId customerId, Email email) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(email);
        appendChange(new RestaurantCustomerEmailUpdated(customerId, email)).apply();
    }

    public void UpdateWaiterPhone(WaiterId waiterId, Phone phone) {
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(phone);
        appendChange(new WaiterPhoneUpdated(waiterId, phone)).apply();
    }

    public void UpdateWaiterEmail(WaiterId waiterId, Email email) {
        Objects.requireNonNull(waiterId);
        Objects.requireNonNull(email);
        appendChange(new WaiterEmailUpdated(waiterId, email)).apply();
    }

    public void ChangeTableColor(TableId tableId, Color color) {
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(color);
        appendChange(new TableColorChanged(tableId, color)).apply();
    }

    public void ChangeTableNumberOfChairs(TableId tableId, NumberOfChairs numberOfChairs) {
        Objects.requireNonNull(tableId);
        Objects.requireNonNull(numberOfChairs);
        appendChange(new TableNumberOfChairsChanged(tableId, numberOfChairs)).apply();
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
