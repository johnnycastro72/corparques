package co.com.sofka.corparques.domain.attraction.events;

import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.generic.values.Message;
import co.com.sofka.domain.generic.DomainEvent;

public class LogisticsNotified extends DomainEvent {
    private final AttractionId attractionId;
    private final Message message;

    public LogisticsNotified(AttractionId attractionId, Message message) {
        super("corparques.sofka.logisticsnotified");
        this.attractionId = attractionId;
        this.message = message;
    }

    public AttractionId attractionId() {
        return attractionId;
    }

    public Message message() {
        return message;
    }
}
