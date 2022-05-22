package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.Capacity;
import co.com.sofka.domain.generic.Command;

public class UpdateCapacity extends Command {
    private final AttractionId attractionId;
    private final Capacity capacity;

    public UpdateCapacity(AttractionId attractionId, Capacity capacity) {
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
