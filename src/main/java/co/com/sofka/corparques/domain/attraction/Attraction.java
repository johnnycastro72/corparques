package co.com.sofka.corparques.domain.attraction;

import co.com.sofka.corparques.domain.attraction.events.*;
import co.com.sofka.corparques.domain.attraction.values.*;
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

public class Attraction extends AggregateEvent<AttractionId> {

    protected Name name;
    protected Capacity capacity;
    protected MinimumHeight minimumHeight;
    protected OperatorId operatorId;
    protected CashierId cashierId;
    protected Set<AttractionCustomer> customers;

    public Attraction(AttractionId attractionId, Name name, Capacity capacity, MinimumHeight minimumHeight, OperatorId operatorId, CashierId cashierId) {
        super(attractionId);
        appendChange(new AttractionCreated(attractionId, name, capacity, minimumHeight, operatorId, cashierId)).apply();
    }

    private Attraction(AttractionId attractionId) {
        super(attractionId);
        subscribe(new AttractionChange(this));
    }

    public static Attraction from(AttractionId attractionId, List<DomainEvent> events) {
        var attraction = new Attraction(attractionId);
        events.forEach(attraction::applyEvent);
        return attraction;
    }

    public void UpdateCapacity(AttractionId attractionId, Capacity capacity) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(capacity);
        appendChange(new CapacityUpdated(attractionId, capacity)).apply();
    }

    public void AssignOperator(AttractionId attractionId, OperatorId operatorId) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(operatorId);
        appendChange(new OperatorAssigned(attractionId, operatorId)).apply();
    }

    public void AssignCashier(AttractionId attractionId, CashierId cashierId) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(cashierId);
        appendChange(new CashierAssigned(attractionId, cashierId)).apply();
    }

    public void AddAttractionCustomer(AttractionId attractionId, CustomerId customerId, Name name, Email email, Phone phone, BirthDate birthDate, Height height, IsPassportUser isPassportUser) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(birthDate);
        Objects.requireNonNull(height);
        Objects.requireNonNull(isPassportUser);
        appendChange(new AttractionCustomerAdded(attractionId, customerId, name, email, phone, birthDate, height, isPassportUser)).apply();
    }

    public void UpdateAttractionCustomerHeight(AttractionId attractionId, CustomerId customerId, Height height) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(height);
        appendChange(new AttractionCustomerHeightUpdated(attractionId, customerId, height)).apply();
    }

    public void UpdateAttractionCustomerPhone(AttractionId attractionId, CustomerId customerId, Phone phone) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(phone);
        appendChange(new AttractionCustomerPhoneUpdated(attractionId, customerId, phone)).apply();
    }

    public void UpdateAttractionCustomerEmail(AttractionId attractionId, CustomerId customerId, Email email) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(email);
        appendChange(new AttractionCustomerEmailUpdated(attractionId, customerId, email)).apply();
    }

    public void ChangeAttractionPassportUser(AttractionId attractionId, CustomerId customerId, IsPassportUser isPassportUser) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(isPassportUser);
        appendChange(new AttractionPassportUserChanged(attractionId, customerId, isPassportUser)).apply();
    }

    public void UpdateOperatorPhone(AttractionId attractionId, OperatorId operatorId, Phone phone) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(phone);
        appendChange(new OperatorPhoneUpdated(attractionId, operatorId, phone)).apply();
    }

    public void UpdateOperatorEmail(AttractionId attractionId, OperatorId operatorId, Email email) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(email);
        appendChange(new OperatorEmailUpdated(attractionId, operatorId, email)).apply();
    }

    public void ChangeOperatorClothes(AttractionId attractionId, OperatorId operatorId, Clothes clothes) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(clothes);
        appendChange(new OperatorClothesChanged(attractionId, operatorId, clothes)).apply();
    }

    public void UpdateCashierPhone(AttractionId attractionId, CashierId cashierId, Phone phone) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(cashierId);
        Objects.requireNonNull(phone);
        appendChange(new CashierPhoneUpdated(attractionId, cashierId, phone)).apply();
    }

    public void UpdateCashierEmail(AttractionId attractionId, CashierId cashierId, Email email) {
        Objects.requireNonNull(attractionId);
        Objects.requireNonNull(cashierId);
        Objects.requireNonNull(email);
        appendChange(new CashierEmailUpdated(attractionId, cashierId, email)).apply();
    }

    protected Optional<AttractionCustomer> getCustomerById(CustomerId customerId) {
        return customers()
                .stream()
                .filter(customer -> customer.identity().equals(customerId))
                .findFirst();
    }

    public Name name() {
        return name;
    }

    public Capacity capacity() {
        return capacity;
    }

    public MinimumHeight minimumHeight() {
        return minimumHeight;
    }

    public OperatorId operatorId() {
        return operatorId;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Set<AttractionCustomer> customers() {
        return customers;
    }

}
