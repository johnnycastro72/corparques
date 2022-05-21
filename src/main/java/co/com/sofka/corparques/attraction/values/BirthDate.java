package co.com.sofka.corparques.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class BirthDate implements ValueObject {
    private final Date value;

    public BirthDate(Date value) {
        this.value = Objects.requireNonNull(value, "The date cannot be null");
        if(value.after(new Date(Instant.now().toEpochMilli()))){
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
