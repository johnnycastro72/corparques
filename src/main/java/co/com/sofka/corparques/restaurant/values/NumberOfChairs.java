package co.com.sofka.corparques.restaurant.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberOfChairs implements ValueObject {
    private final Integer value;

    public NumberOfChairs(Integer value) {
        this.value = Objects.requireNonNull(value, "Table's number of chairs can't be null");
        if(this.value <= 2){
            throw new IllegalArgumentException("A table needs at least two chairs to be useful.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfChairs that = (NumberOfChairs) o;
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
