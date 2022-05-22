package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MinimumHeight implements ValueObject {

    private final Double value;

    public MinimumHeight(Double value) {
        this.value = Objects.requireNonNull(value, "Customer minimum height can't be null");
        if(0>=this.value){
            throw new IllegalArgumentException("Customer minimum height can't be negative or zero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinimumHeight that = (MinimumHeight) o;
        return value.equals(that.value);
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
