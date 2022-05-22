package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.AssignCashier;

public class AssignCashierUseCase extends UseCase<RequestCommand<AssignCashier>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignCashier> assignCashierRequestCommand) {
        var command = assignCashierRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.AssignCashier(command.attractionId(), command.cashierId());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
