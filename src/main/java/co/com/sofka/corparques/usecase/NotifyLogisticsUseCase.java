package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.values.AttractionId;
import co.com.sofka.corparques.domain.generic.values.Message;

public class NotifyLogisticsUseCase extends UseCase<TriggeredEvent<AttractionCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AttractionCreated> attractionCreatedTriggeredEvent) {
        var event = attractionCreatedTriggeredEvent.getDomainEvent();
        var attraction = Attraction.from(AttractionId.of(event.attractionId().value()), this.retrieveEvents());
        attraction.NotifyLogistics(event.attractionId(),
                new Message("The attraction has been created and is available, please play it throughout the park."));
        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
