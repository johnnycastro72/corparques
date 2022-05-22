package co.com.sofka.corparques.domain.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Message implements ValueObject {
    private final String value;

    public Message(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Message can't be blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return value.equals(message.value);
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
