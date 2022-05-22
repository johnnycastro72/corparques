package co.com.sofka.corparques.domain.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Phone implements ValueObject {

    private final String value;

    public Phone(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Phone can't be blank");
        }

        if (this.value.length() < 5) {
            throw new IllegalArgumentException("Phone must be longer than six characters");
        }

        if (!value.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$")) {
            throw new IllegalArgumentException("Phone is not valid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return value.equals(phone.value);
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
