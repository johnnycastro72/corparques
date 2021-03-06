package co.com.sofka.corparques.domain.attraction;

import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;


public class Cashier extends Entity<CashierId> {
    private Name name;
    private Email email;
    private Phone phone;

    public Cashier(CashierId cashierId) {
        super(cashierId);
    }

    public Cashier(CashierId cashierId, Name name, Email email, Phone phone) {
        super(cashierId);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void UpdateEmail(Email email) {
        this.email = Objects.requireNonNull(email);
    }

    public void UpdatePhone(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public Name name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public Phone phone() {
        return phone;
    }
}
