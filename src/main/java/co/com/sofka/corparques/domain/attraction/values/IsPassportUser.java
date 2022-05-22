package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsPassportUser implements ValueObject {

    private final Boolean value;

    public IsPassportUser(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsPassportUser that = (IsPassportUser) o;
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
