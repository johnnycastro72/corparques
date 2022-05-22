package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.restaurant.Restaurant;
import co.com.sofka.corparques.domain.restaurant.commands.CreateRestaurant;

public class CreateRestaurantUseCase extends UseCase<RequestCommand<CreateRestaurant>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRestaurant> createRestaurantRequestCommand) {
        var command = createRestaurantRequestCommand.getCommand();

        var restaurant = new Restaurant(command.restaurantId(),
                command.name(),
                command.location());

        emit().onResponse(new ResponseEvents(restaurant.getUncommittedChanges()));

    }
}
