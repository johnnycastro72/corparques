package co.com.sofka.corparques.attraction;

import co.com.sofka.corparques.attraction.values.AttractionId;
import co.com.sofka.corparques.attraction.values.Capacity;
import co.com.sofka.corparques.attraction.values.CashierId;
import co.com.sofka.corparques.attraction.values.OperatorId;
import co.com.sofka.corparques.shared.Name;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Identity;

public class Attraction extends AggregateEvent<AttractionId> {

    public Attraction(AttractionId attractionId, Name name, Capacity capacity, MinimumHeight minimumHeight, OperatorId operatorId, CashierId cashierId) {

    }

    private Attraction(AttractionId attractionId) {
        super(attractionId);
    }
}
