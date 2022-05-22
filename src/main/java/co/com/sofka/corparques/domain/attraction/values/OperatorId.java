package co.com.sofka.corparques.domain.attraction.values;

import co.com.sofka.domain.generic.Identity;

public class OperatorId extends Identity {

    public OperatorId() {
    }

    private OperatorId(String id) {
        super(id);
    }

    public static OperatorId of(String id) {
        return new OperatorId(id);
    }

}
