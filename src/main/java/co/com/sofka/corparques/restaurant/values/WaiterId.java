package co.com.sofka.corparques.restaurant.values;

import co.com.sofka.domain.generic.Identity;

public class WaiterId extends Identity {
    public WaiterId() {
    }

    private WaiterId(String id) {
        super(id);
    }

    public static WaiterId of(String id) {
        return new WaiterId(id);
    }

}
