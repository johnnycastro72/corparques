package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacity implements ValueObject {

    private final Integer value;

    public Capacity(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capacity capacity = (Capacity) o;
        return value.equals(capacity.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Object value() {
        return value;
    }
}
