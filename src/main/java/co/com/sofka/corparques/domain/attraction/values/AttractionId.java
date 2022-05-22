package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.Identity;

public class AttractionId extends Identity {
    public AttractionId() {
    }

    private AttractionId(String id) {
        super(id);
    }

    public static AttractionId of(String id) {
        return new AttractionId(id);
    }

}
