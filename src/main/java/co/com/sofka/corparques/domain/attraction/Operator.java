package co.com.sofka.corparques.domain.attraction;

import co.com.sofka.corparques.domain.attraction.values.Clothes;
import co.com.sofka.corparques.domain.attraction.values.OperatorId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Operator extends Entity<OperatorId> {
    private Name name;
    private Email email;
    private Phone phone;
    private Clothes clothes;

    public Operator(OperatorId operatorId) {
        super(operatorId);
    }

    public Operator(OperatorId operatorId, Name name, Email email, Phone phone, Clothes clothes) {
        super(operatorId);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.clothes = clothes;
    }

    public void UpdateEmail(Email email) {
        this.email = Objects.requireNonNull(email);
    }

    public void UpdatePhone(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public void ChangeClothes(Clothes clothes) {
        this.clothes = clothes;
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

    public Clothes clothes() {
        return clothes;
    }
}
