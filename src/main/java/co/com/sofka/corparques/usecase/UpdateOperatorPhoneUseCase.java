package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateOperatorPhone;

public class UpdateOperatorPhoneUseCase extends UseCase<RequestCommand<UpdateOperatorPhone>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateOperatorPhone> updateOperatorPhoneRequestCommand) {
        var command = updateOperatorPhoneRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateOperatorPhone(command.attractionId(), command.operatorId(), command.phone());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
