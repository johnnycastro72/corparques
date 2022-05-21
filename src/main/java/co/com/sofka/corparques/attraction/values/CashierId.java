package co.com.sofka.corparques.attraction.values;

import co.com.sofka.domain.generic.Identity;

public class CashierId extends Identity {
    public CashierId() {
    }

    private CashierId(String id) {
        super(id);
    }

    public static CashierId of(String id) {
        return new CashierId(id);
    }

}
