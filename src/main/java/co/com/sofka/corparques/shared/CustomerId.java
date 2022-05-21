package co.com.sofka.corparques.shared;

import co.com.sofka.corparques.attraction.values.AttractionId;
import co.com.sofka.domain.generic.Identity;

public class CustomerId extends Identity {
    public CustomerId() {
    }

    private CustomerId(String id) {
        super(id);
    }

    public static CustomerId of(String id) {
        return new CustomerId(id);
    }

}
