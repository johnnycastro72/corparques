package co.com.sofka.corparques.restaurant;

import co.com.sofka.corparques.restaurant.values.WaiterId;
import co.com.sofka.corparques.shared.Email;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.corparques.shared.Phone;
import co.com.sofka.domain.generic.Entity;

public class Waiter extends Entity<WaiterId> {
    private Name name;
    private Email email;
    private Phone phone;

    public Waiter(WaiterId waiterId) {
        super(waiterId);
    }

    public Waiter(WaiterId waiterId, Name name, Email email, Phone phone) {
        super(waiterId);
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void UpdateEmail(Email email) {
        this.email = email;
    }

    public void UpdatePhone(Phone phone) {
        this.phone = phone;
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
