package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateCashierEmail;

public class UpdateCashierEmailUseCase extends UseCase<RequestCommand<UpdateCashierEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCashierEmail> updateCashierEmailRequestCommand) {
        var command = updateCashierEmailRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateCashierEmail(command.attractionId(), command.cashierId(), command.email());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
