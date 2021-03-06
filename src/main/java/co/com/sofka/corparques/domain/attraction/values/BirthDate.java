package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class BirthDate implements ValueObject {
    private final LocalDateTime value;

    public BirthDate(LocalDateTime value) {
        this.value = Objects.requireNonNull(value, "The date cannot be null");
        if(value.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("The birth date must be before the current date");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return value.equals(birthDate.value);
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
