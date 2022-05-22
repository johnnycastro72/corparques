package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.Capacity;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacityUpdated extends DomainEvent {
    private final Capacity capacity;

    public CapacityUpdated(Capacity capacity) {
        super("corparques.sofka.capacityupdated");
        this.capacity = capacity;
    }

    public Capacity capacity() {
        return capacity;
    }
}
