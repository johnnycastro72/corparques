package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.domain.generic.Command;

public class UpdateCashierEmail extends Command {
    private final AttractionId attractionId;
    private final CashierId cashierId;
    private final Email email;

    public UpdateCashierEmail(AttractionId attractionId, CashierId cashierId, Email email) {
        this.attractionId = attractionId;
        this.cashierId = cashierId;
        this.email = email;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Email email() {
        return email;
    }
}
