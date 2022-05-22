package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateOperatorEmail;

public class UpdateOperatorEmailUseCase extends UseCase<RequestCommand<UpdateOperatorEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateOperatorEmail> updateOperatorEmailRequestCommand) {
        var command = updateOperatorEmailRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateOperatorEmail(command.attractionId(), command.operatorId(), command.email());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
