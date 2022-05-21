package co.com.sofka.corparques.attraction;

import co.com.sofka.corparques.attraction.events.AttractionCreated;
import co.com.sofka.corparques.attraction.events.CapacityUpdated;
import co.com.sofka.corparques.attraction.events.OperatorAssigned;
import co.com.sofka.corparques.attraction.values.*;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
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
}
