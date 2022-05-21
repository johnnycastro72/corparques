package co.com.sofka.corparques.attraction.events;

import co.com.sofka.corparques.attraction.values.AttractionId;
import co.com.sofka.corparques.attraction.values.Capacity;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacityUpdated extends DomainEvent {
    public CapacityUpdated(AttractionId attractionId, Capacity capacity) {
        super("corparques.sofka.capacityupdated");
    }
}
