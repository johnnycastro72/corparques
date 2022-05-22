package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.Capacity;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacityUpdated extends DomainEvent {
    private final AttractionId attractionId;
    private final Capacity capacity;

    public CapacityUpdated(AttractionId attractionId, Capacity capacity) {
        super("corparques.sofka.capacityupdated");
        this.attractionId = attractionId;
        this.capacity = capacity;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public Capacity capacity() {
        return capacity;
    }
}
