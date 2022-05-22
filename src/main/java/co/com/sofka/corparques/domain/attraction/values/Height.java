package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Height implements ValueObject {
    private final Double value;

    public Height(Double value) {
        this.value = Objects.requireNonNull(value, "Customer height can't be null");
        if(0>=this.value){
            throw new IllegalArgumentException("Customer height can't be negative or zero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return value.equals(height.value);
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
