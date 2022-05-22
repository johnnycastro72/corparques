package co.com.sofka.corparques.domain.attraction.commands;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.attraction.values.CashierId;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.Command;

public class UpdateCashierPhone extends Command {
    private final AttractionId attractionId;
    private final CashierId cashierId;
    private final Phone phone;

    public UpdateCashierPhone(AttractionId attractionId, CashierId cashierId, Phone phone) {
        this.attractionId = attractionId;
        this.cashierId = cashierId;
        this.phone = phone;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public CashierId cashierId() {
        return cashierId;
    }

    public Phone phone() {
        return phone;
    }
}
