package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.Capacity;
import co.com.sofka.domain.generic.Command;

public class UpdateCapacity extends Command {
    private final Capacity capacity;

    public UpdateCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Capacity capacity() {
        return capacity;
    }
}