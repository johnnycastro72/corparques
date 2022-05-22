package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.corparques.domain.generic.values.Message;
import co.com.sofka.corparques.domain.restaurant.Restaurant;
import co.com.sofka.corparques.domain.restaurant.events.RestaurantCreated;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;

public class RestaurantNotifyLogisticsUseCase extends UseCase<TriggeredEvent<RestaurantCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RestaurantCreated> restaurantCreatedTriggeredEvent) {
        var event = restaurantCreatedTriggeredEvent.getDomainEvent();
        var restaurant = Restaurant.from(RestaurantId.of(event.restaurantId().value()), this.retrieveEvents());
        restaurant.RestaurantNotifyLogistics(event.restaurantId(),
                new Message("The restaurant has been created and is available, please play it throughout the park."));
        emit().onResponse(new ResponseEvents(restaurant.getUncommittedChanges()));
    }
}
