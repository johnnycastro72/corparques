package co.com.sofka.corparques.attraction;

import co.com.sofka.corparques.attraction.events.*;
import co.com.sofka.corparques.attraction.values.*;
import co.com.sofka.corparques.shared.CustomerId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.corparques.shared.Phone;
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

    public void UpdateCapacity(Capacity capacity) {
        Objects.requireNonNull(capacity);
        appendChange(new CapacityUpdated(capacity)).apply();
    }

    public void AssignOperator(OperatorId operatorId) {
        Objects.requireNonNull(operatorId);
        appendChange(new OperatorAssigned(operatorId)).apply();
    }

    public void AssignCashier(CashierId cashierId) {
        Objects.requireNonNull(cashierId);
        appendChange(new CashierAssigned(cashierId)).apply();
    }

    public void AddAttractionCustomer(CustomerId customerId, Name name, Email email, Phone phone, BirthDate birthDate, Height height, IsPassportUser isPassportUser) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(birthDate);
        Objects.requireNonNull(height);
        Objects.requireNonNull(isPassportUser);
        appendChange(new AttractionCustomerAdded(customerId, name, email, phone, birthDate, height, isPassportUser)).apply();
    }

    public void UpdateAttractionCustomerHeight(CustomerId customerId, Height height) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(height);
        appendChange(new AttractionCustomerHeightUpdated(customerId, height)).apply();
    }

    public void UpdateAttractionCustomerPhone(CustomerId customerId, Phone phone) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(phone);
        appendChange(new AttractionCustomerPhoneUpdated(customerId, phone)).apply();
    }

    private void UpdateAttractionCustomerEmail(CustomerId customerId, Email email) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(email);
        appendChange(new AttractionCustomerEmailUpdated(customerId, email)).apply();
    }

    private void ChangeAttractionPassportUser(CustomerId customerId, IsPassportUser isPassportUser) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(isPassportUser);
        appendChange(new AttractionPassportUserChanged(customerId, isPassportUser)).apply();
    }

    private void UpdateOperatorPhone(OperatorId operatorId, Phone phone) {
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(phone);
        appendChange(new OperatorPhoneUpdated(operatorId, phone)).apply();
    }

    public void UpdateOperatorEmail(OperatorId operatorId, Email email) {
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(email);
        appendChange(new OperatorEmailUpdated(operatorId, email)).apply();
    }

    public void ChangeOperatorClothes(OperatorId operatorId, Clothes clothes) {
        Objects.requireNonNull(operatorId);
        Objects.requireNonNull(clothes);
        appendChange(new OperatorClothesChanged(operatorId, clothes)).apply();
    }

    public void UpdateCashierPhone(CashierId cashierId, Phone phone) {
        Objects.requireNonNull(cashierId);
        Objects.requireNonNull(phone);
        appendChange(new CashierPhoneUpdated(cashierId, phone)).apply();
    }

    public void UpdateCashierEmail(CashierId cashierId, Email email) {
        Objects.requireNonNull(cashierId);
        Objects.requireNonNull(email);
        appendChange(new CashierEmailUpdated(cashierId, email)).apply();
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
