package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.AssignOperator;

public class AssignOperatorUseCase extends UseCase<RequestCommand<AssignOperator>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignOperator> assignOperatorRequestCommand) {
        var command = assignOperatorRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.operatorId().value()));
        attraction.AssignOperator(command.attractionId(), command.operatorId());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
