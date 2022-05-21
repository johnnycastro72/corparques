package co.com.sofka.corparques.restaurant.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Location implements ValueObject {

    private final String value;

    public Location(String value){

        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Location can't be blank");
        }
        if (this.value.length() < 5) {
            throw new IllegalArgumentException("Location must be at least 6 characters long");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return value.equals(location.value);
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
